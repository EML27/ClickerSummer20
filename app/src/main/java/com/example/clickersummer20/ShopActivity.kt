package com.example.clickersummer20

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.clickersummer20.rv1.Rv1Adapter
import com.example.clickersummer20.rv2.Rv2Adapter
import kotlinx.android.synthetic.main.activity_shop.*

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        var sp = getSharedPreferences(Keys.DATA_ABOUT_APP, Context.MODE_PRIVATE)

        rvActiveImprovements.adapter = Rv1Adapter(ItemActiveName.list, { itemActive: ItemActive, textView: TextView ->
            var counter = sp.getLong(Keys.COUNT_OF_OIL,0)
            if (counter<itemActive.cost){
                Toast.makeText(this,"У тебя нет денег, иди работай", Toast.LENGTH_SHORT).show()
            }
            else{
                sp.edit().apply{
                    putLong(Keys.COUNT_OF_OIL,counter-itemActive.cost)
                    putInt(itemActive.id,sp.getInt(itemActive.id,0)+1)
                    apply()
                }
                textView.text = sp.getInt(itemActive.id,0).toString()
            }
        },
            { itemActive: ItemActive, textView: TextView ->
                var sp = getSharedPreferences(Keys.DATA_ABOUT_APP, Context.MODE_PRIVATE)
            textView.text = sp.getInt(itemActive.id,0).toString()

        })

        rvPassiveImprovements.adapter = Rv2Adapter(ItemPassiveName.list, { itemPassive: ItemPassive, textView: TextView ->
            var counter = sp.getLong(Keys.COUNT_OF_OIL,0)
            if (counter<itemPassive.cost){
                Toast.makeText(this,"У тебя нет денег, иди работай",Toast.LENGTH_SHORT).show()
            }
            else {
                sp.edit().apply() {
                    putLong(Keys.COUNT_OF_OIL, counter - itemPassive.cost)
                    putInt(itemPassive.id, sp.getInt(itemPassive.id, 0) + 1)
                    apply()
                }
                textView.text = sp.getInt(itemPassive.id, 0).toString()
            }
        },
            {
                itemPassive: ItemPassive, textView: TextView ->
                var sp = getSharedPreferences(Keys.DATA_ABOUT_APP,Context.MODE_PRIVATE)
                textView.text = sp.getInt(itemPassive.id,0).toString()
            })


        btnGoToMain.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

}