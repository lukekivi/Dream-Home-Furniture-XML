package com.dreamhomefurniturexml

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.dreamhomefurniturexml.adapter.FurnitureCardAdapter
import com.dreamhomefurniturexml.viewmodels.FurnitureDataState
import com.dreamhomefurniturexml.viewmodels.MainScreenViewModel
import com.dreamhomefurniturexml.viewmodels.MainScreenViewModelImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val vm: MainScreenViewModel by viewModels<MainScreenViewModelImpl>()
    private lateinit var furnitureCardRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        furnitureCardRecyclerView = findViewById(R.id.furniture_card_recycler_view)

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
                            furnitureCardRecyclerView.adapter = FurnitureCardAdapter(
                                    mainScreenContent.furnitureDataState.simpleFurnitureDataList
                                )

                            // Use this setting to improve performance if you know that changes
                            // in content do not change the layout size of the RecyclerView
                            furnitureCardRecyclerView.setHasFixedSize(true)
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