package com.example.clickersummer20

object ItemPassiveName {
    var list: List<ItemPassive>

    init {
        list = listOf<ItemPassive>(
            ItemPassive("Шахта","1"),
            ItemPassive("Лайнер","2"),
            ItemPassive("Компания","3")
        )

    }
}