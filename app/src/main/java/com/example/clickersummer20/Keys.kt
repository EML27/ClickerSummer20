package com.example.clickersummer20

class Keys {
    companion object {
        val DATA_ABOUT_APP = "data" // Название файла SharedPreferences

        val COUNT_OF_OIL = "oil" // Значение в SharedPreferenec, которое соответсвует текущему значению
                                 //     валюты

        val INCREASE_OIL = "increase" // Значение пассивного дохода в SharedPref. То число, на которое
                                      //    каждую секунду будет расти счётчик

        val CLICK_INCREASE_OIL = "click_increase" // Значение, на которое будет увеличиваться счётчик
                                                  //    валюты при клике на кнопку
    }
}