package com.example.clickersummer20

object ItemActiveName {
    var list: List<ItemActive>

    init {
        list = listOf<ItemActive>(
            ItemActive("Сотрудник", 1, Keys.COLLEAGUE_ID,100),
            ItemActive("Ковш", 2,Keys.DIPPER_ID,200),
            ItemActive("Бур", 3, Keys.BOER_ID,300)
        )
    }
}