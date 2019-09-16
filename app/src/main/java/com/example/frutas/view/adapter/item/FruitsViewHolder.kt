package com.example.frutas.view.adapter.item

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.frutas.apicall.getfruits.model.ApiFruits
import com.example.frutas.controller.model.PresentationFruits
import kotlinx.android.synthetic.main.fruit_list_item.view.*

class FruitsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val tvFruitItem = view.fruitItem

    fun onBind(item: PresentationFruits) {

        refreshView(item)
    }

    fun refreshView(item: PresentationFruits) {

        tvFruitItem.setText(item.name)
    }
}