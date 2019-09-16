package com.example.frutas.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.frutas.R
import com.example.frutas.apicall.getfruits.model.ApiFruits
import com.example.frutas.controller.model.PresentationFruits
import com.example.frutas.view.adapter.item.FruitsViewHolder

class FruitAdapter(val mItems: ArrayList<PresentationFruits>, val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return FruitsViewHolder(LayoutInflater.from(context).inflate(R.layout.fruit_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as FruitsViewHolder).onBind(mItems[position])

    }

    override fun getItemCount(): Int {

        return mItems.size
    }

    fun addItems(itemsToAdd: List<PresentationFruits>) {

        mItems.addAll(itemsToAdd)
        notifyDataSetChanged()
    }

    fun clear() {

        mItems.clear()
        notifyDataSetChanged()
    }
}