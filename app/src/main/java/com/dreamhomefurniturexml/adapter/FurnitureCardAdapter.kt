package com.dreamhomefurniturexml.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dreamhomefurniturexml.ui.components.FurnitureCard
import com.dreamhomefurniturexml.ui.components.FurnitureCardData

/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */
class FurnitureCardAdapter(
    private val furnitureCardDataList: List<FurnitureCardData>
) : RecyclerView.Adapter<FurnitureCardAdapter.ItemViewHolder>() {

    class ItemViewHolder(val furnitureCard: FurnitureCard) : RecyclerView.ViewHolder(furnitureCard)

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(FurnitureCard(parent.context))
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