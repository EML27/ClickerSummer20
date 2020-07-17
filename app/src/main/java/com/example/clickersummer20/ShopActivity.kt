package com.example.clickersummer20

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.clickersummer20.rv1.Rv1Adapter
import com.example.clickersummer20.rv2.Rv2Adapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_shop.*
import kotlinx.android.synthetic.main.item_view.*
import java.util.*
import kotlin.math.pow

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        var sp = getSharedPreferences(Keys.DATA_ABOUT_APP, Context.MODE_PRIVATE)

        getCountOfOil(sp)

        rvActiveImprovements.adapter = Rv1Adapter(ItemActiveName.list, { itemActive: ItemActive, textView: TextView ->
            var counter = sp.getLong(Keys.COUNT_OF_OIL,0)
            if (counter<itemActive.cost){
                Toast.makeText(this,"У тебя нет денег, иди работай", Toast.LENGTH_SHORT).show()
            }
            else{
                sp.edit().apply {
                    putLong(Keys.COUNT_OF_OIL,counter-itemActive.cost)
                    putInt(itemActive.id,sp.getInt(itemActive.id,0)+1)
                    putLong(Keys.CLICK_INCREASE_OIL,
                        sp.getLong(Keys.CLICK_INCREASE_OIL,0)+itemActive.upgrade)
                    apply()
                }
                textView.text = sp.getInt(itemActive.id,0).toString()
                itemActive.cost = (itemActive.cost*1.2).toInt()
                shopMoneyField.text = "${sp.getLong(Keys.COUNT_OF_OIL,0)}"
            }
        },
            { itemActive: ItemActive, textView: TextView ->
                var sp = getSharedPreferences(Keys.DATA_ABOUT_APP, Context.MODE_PRIVATE)
                if(ItemActiveName.getInitialCounts().contains(itemActive.cost)) {
                    itemActive.cost =
                        (1.2.pow(sp.getInt(itemActive.id, 0).toDouble()) * itemActive.cost).toInt()
                }
                textView.text = sp.getInt(itemActive.id,0).toString()
        })

        rvPassiveImprovements.adapter = Rv2Adapter(ItemPassiveName.list, { itemPassive: ItemPassive, textView: TextView ->
            var counter = sp.getLong(Keys.COUNT_OF_OIL,0)
            if (counter<itemPassive.cost){
                Toast.makeText(this,"У тебя нет денег, иди работай",Toast.LENGTH_SHORT).show()
            }
            else {
                sp.edit().apply {
                    putLong(Keys.COUNT_OF_OIL, counter - itemPassive.cost)
                    putInt(itemPassive.id, sp.getInt(itemPassive.id, 0) + 1)
                    putLong(Keys.INCREASE_OIL,
                        sp.getLong(Keys.INCREASE_OIL,0)+itemPassive.upgrade)
                    apply()
                }
                textView.text = sp.getInt(itemPassive.id, 0).toString()
                itemPassive.cost = (itemPassive.cost*1.2).toInt()
                shopMoneyField.text = "${sp.getLong(Keys.COUNT_OF_OIL,0)}"
            }
        },
            {
                itemPassive: ItemPassive, textView: TextView ->
                var sp = getSharedPreferences(Keys.DATA_ABOUT_APP,Context.MODE_PRIVATE)
                if(ItemPassiveName.getInitialCosts().contains(itemPassive.cost)) {
                    itemPassive.cost = (1.2.pow(
                        sp.getInt(itemPassive.id, 0).toDouble()
                    ) * itemPassive.cost).toInt()
                }
                textView.text = sp.getInt(itemPassive.id, 0).toString()
            })


        btnGoToMain.setOnClickListener {
            onBackPressed()
        }
    }

    private fun getCountOfOil(sp: SharedPreferences) {
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                var counter = sp.getLong(Keys.COUNT_OF_OIL,0)
                runOnUiThread(Runnable {
                    shopMoneyField.text = "${counter}"
                })
            }
        }, 0, 1100)
    }

}