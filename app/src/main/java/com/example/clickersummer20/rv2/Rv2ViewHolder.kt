package com.example.clickersummer20.rv2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clickersummer20.ItemActive
import com.example.clickersummer20.ItemPassive
import com.example.clickersummer20.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_view.*

class Rv2ViewHolder(
    override val containerView: View,
    private val clickLambda: (ItemPassive, TextView) -> Unit,
    private val initLambda: (ItemPassive, TextView) -> Unit
) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(item: ItemPassive) {
        initLambda(item,tvElementCounter)
        Name_item.text = item.nameItem
        Upgrade.text = "+${item.upgrade}/сек"
        btnToast.text = item.cost.toString()
        btnToast.setOnClickListener {
            clickLambda(item,tvElementCounter)
            btnToast.text = item.cost.toString()
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            clickLambda: (ItemPassive,TextView) -> Unit,
            initLambda: (ItemPassive,TextView)  -> Unit
        ) = Rv2ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view,
                parent,
                false
            ), clickLambda, initLambda
        )
    }
}