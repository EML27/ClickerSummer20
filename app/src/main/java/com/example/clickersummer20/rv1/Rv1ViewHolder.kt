package com.example.clickersummer20.rv1

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clickersummer20.ItemActive
import com.example.clickersummer20.Keys
import com.example.clickersummer20.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_view.*

class Rv1ViewHolder(override val containerView: View, private val clickLambda: (ItemActive, TextView) -> Unit) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {


    fun bind(item: ItemActive) {
        Name_item.text = item.nameItem
        Upgrade.text = item.upgrade.toString()
        btnToast.setOnClickListener {
            clickLambda(item,tvElementCounter)


        }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (ItemActive,TextView) -> Unit) = Rv1ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view,
                parent,
                false
            ), clickLambda
        )
    }
}