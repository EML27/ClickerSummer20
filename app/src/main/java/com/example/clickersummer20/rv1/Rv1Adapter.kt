package com.example.clickersummer20.rv1

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clickersummer20.ItemActive


class Rv1Adapter(
    private val dataSrc: List<ItemActive>,
    private val clickLambda: (ItemActive, TextView) -> Unit,
    private val initLambda :(ItemActive,TextView)->Unit
) :
    RecyclerView.Adapter<Rv1ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Rv1ViewHolder =
        Rv1ViewHolder.create(parent, clickLambda,initLambda)

    override fun getItemCount(): Int = dataSrc.size

    override fun onBindViewHolder(holder: Rv1ViewHolder, position: Int) =
        holder.bind(dataSrc[position])
}