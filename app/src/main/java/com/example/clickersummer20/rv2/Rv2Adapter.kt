package com.example.clickersummer20.rv2

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clickersummer20.ItemActive
import com.example.clickersummer20.ItemPassive


class Rv2Adapter(
    private val dataSrc: List<ItemPassive>,
    private val clickLambda: (ItemPassive, TextView) -> Unit,
    private val initLambda :(ItemPassive, TextView)->Unit
) :
    RecyclerView.Adapter<Rv2ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Rv2ViewHolder =
        Rv2ViewHolder.create(parent, clickLambda,initLambda)

    override fun getItemCount(): Int = dataSrc.size

    override fun onBindViewHolder(holder: Rv2ViewHolder, position: Int) =
        holder.bind(dataSrc[position])
}