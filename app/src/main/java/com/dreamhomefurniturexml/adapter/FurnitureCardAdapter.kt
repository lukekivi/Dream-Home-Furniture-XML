package com.dreamhomefurniturexml.adapter

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.dreamhomefurniturexml.ui.components.FurnitureCard
import com.dreamhomefurniturexml.ui.components.FurnitureCardData

/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */
class FurnitureCardAdapter(
    private val furnitureCardDataList: List<FurnitureCardData>,
    context: Context
) : RecyclerView.Adapter<FurnitureCardAdapter.ItemViewHolder>() {
    private val scale: Float = context.resources.displayMetrics.density
    private val padding = (8 * scale + 0.5f).toInt()

    class ItemViewHolder(val furnitureCard: FurnitureCard) : RecyclerView.ViewHolder(furnitureCard)

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val item = FurnitureCard(parent.context)
        item.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
        item.setPadding(padding)
        return ItemViewHolder(item)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.furnitureCard.update(furnitureCardDataList[position])
        holder.furnitureCard.setCompareButtonOnClickListener { Log.d("CompareButton", "Card $position was clicked") }
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = furnitureCardDataList.size
}