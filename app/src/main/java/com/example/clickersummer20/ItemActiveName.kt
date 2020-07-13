package com.example.clickersummer20

object ItemActiveName {
    var list: List<ItemActive>

    init {
        list = listOf<ItemActive>(
            ItemActive("Два пальца", "Лучший"),
            ItemActive("Три пальца", "Красава"),
            ItemActive("Четыре пальца", "Браатан!")
        )
    }
}