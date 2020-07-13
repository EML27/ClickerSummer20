package com.example.clickersummer20.rv1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clickersummer20.ItemActive
import com.example.clickersummer20.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_view.*

class Rv1ViewHolder(override val containerView: View, private val clickLambda: (ItemActive) -> Unit) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(item: ItemActive) {
        Name_item.text = item.nameItem
        Upgrade.text = item.upgrade
        btnToast.setOnClickListener { clickLambda(item) }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (ItemActive) -> Unit) = Rv1ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view,
                parent,
                false
            ), clickLambda
        )
    }
}