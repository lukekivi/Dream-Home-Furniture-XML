package com.dreamhomefurniturexml.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.View

data class FurnitureCardData(
    val title: String,
    val price: String,
    val vendorTitle: String,
    val collection: String,
    val imageUrl: String?
)

class FurnitureCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): View(context, attrs, defStyleAttr) {

}