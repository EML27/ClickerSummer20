package com.example.clickersummer20

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat



class IncreaseCountOfOil : Service() {

    var temp = 0

    private val CHANNEL_ID = "17"
    private var mt: MyThread? = null

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent.let {
            when(intent?.action) {
                "start" -> {
                    start()
                }
                "stop" -> {
                    stop()
                }
                else -> {}
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun setNotification() {
        val notManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Counting"
            val descriptionText = "Count things"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel =
                notManager.getNotificationChannel(CHANNEL_ID) ?: NotificationChannel(
                    CHANNEL_ID,
                    name,
                    importance
                ).apply {
                    description = descriptionText
                }
            notManager.createNotificationChannel(channel)
        }

        val not = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Пассивный доход... ${getSharedPreferences(Keys.DATA_ABOUT_APP, Context.MODE_PRIVATE)
                .getLong(Keys.COUNT_OF_OIL,0)}")
            .setSmallIcon(R.drawable.ic_android_black_24dp)
            .setVibrate(null)
            .setSound(null)
            .build()

        notManager.notify(1,not)
        startForeground(1, not)
    }

    private fun stop() {
        mt?.mustGo = false
        stopForeground(true)
        stopSelf()
    }

    private fun start() {
        if(mt == null) {
            mt = MyThread()
        }
        mt?.start()
    }

    inner class MyThread : Thread() {
        var mustGo = true
        private val waitTime = 1000.toLong()

        override fun run() {
            super.run()
            var sp = getSharedPreferences(Keys.DATA_ABOUT_APP, Context.MODE_PRIVATE)
            while(mustGo) {
                var counter = sp.getLong(Keys.COUNT_OF_OIL,0)
                counter += sp.getLong(Keys.INCREASE_OIL,0)

                sp.edit().apply {
                    putLong(Keys.COUNT_OF_OIL,counter)
                    apply()
                }

                setNotification()

                sleep(1000)
            }
        }
    }

}
