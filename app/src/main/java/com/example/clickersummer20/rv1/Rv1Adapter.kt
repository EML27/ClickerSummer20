package com.example.clickersummer20.rv1

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clickersummer20.ItemActive


class Rv1Adapter(private val dataSrc: List<ItemActive>, private val clickLambda: (ItemActive) -> Unit) :
    RecyclerView.Adapter<Rv1ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Rv1ViewHolder =
        Rv1ViewHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = dataSrc.size

    override fun onBindViewHolder(holder: Rv1ViewHolder, position: Int) =
        holder.bind(dataSrc[position])
}