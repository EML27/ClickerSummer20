package com.example.clickersummer20

object ItemPassiveName {
    var list: List<ItemPassive>

    init {
        list = listOf<ItemPassive>(
            ItemPassive("Шахта",1,Keys.MINE_ID,1000),
            ItemPassive("Лайнер",2,Keys.LINER_ID,5000),
            ItemPassive("Компания",3,Keys.COMPANY_ID,10000)
        )
    }
    fun getInitialCosts() : List<Int> {
        return listOf(1000,5000,10000)
    }
}