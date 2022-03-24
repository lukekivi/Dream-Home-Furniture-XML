package com.dreamhomefurniturexml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dreamhomefurniturexml.ui.components.FurnitureCard
import com.dreamhomefurniturexml.viewmodels.FurnitureDataState
import com.dreamhomefurniturexml.viewmodels.MainScreenViewModel
import com.dreamhomefurniturexml.viewmodels.MainScreenViewModelImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val vm: MainScreenViewModel by viewModels<MainScreenViewModelImpl>()
    private lateinit var furnitureCard: FurnitureCard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        furnitureCard = findViewById(R.id.furniture_card)
        furnitureCard.setCompareButtonOnClickListener { Log.d("CompareButton", "I was clicked") }

        lifecycleScope.launch {                             // launch a coroutine tied to the lifecycle of the app
            repeatOnLifecycle(Lifecycle.State.STARTED) {    // coroutine only runs when app state is at or above STARTED

                /**
                 * Collect changes in furniture data state
                 */
                vm.mainScreenContentFlow.collect { mainScreenContent ->

                    when (mainScreenContent.furnitureDataState) {   // handle each state differently
                        is FurnitureDataState.Success -> {
                            /**
                             * If there is data in the simpleFurnitureDataList update [furnitureCard] to display it
                             */
                            mainScreenContent.furnitureDataState.simpleFurnitureDataList.firstOrNull()?.let { furnitureCardData ->
                                furnitureCard.update(furnitureCardData)
                            }
                        }
                        else -> {
                            // do something with other states
                        }
                    }
                }
            }
        }
    }
}