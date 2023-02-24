package com.example.myfirstapp


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.myfirstapp.data.Notification

class MainActivity : AppCompatActivity() {

    val channelId = "channelId"
    val channelName = "channelName"
    val notificationId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()

        val intent = Intent(this, NotificationActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0,PendingIntent.FLAG_MUTABLE)
        }

        val notification1 = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Hey Varna!!")
            .setContentText("Good Morning")
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val notification2 = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Hey Varna!!")
            .setContentText("Good Night")
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)

        val btnMrng = findViewById<Button>(R.id.button3)
        val btnNght = findViewById<Button>(R.id.button4)
        val msg = findViewById<TextView>(R.id.textView)

        btnMrng.setOnClickListener {
           msg.text = "GOOD MORNING"
            notificationManager.notify(notificationId, notification1)
            val intent = Intent(this, NotificationActivity::class.java,)
            startActivity(intent)
        }
        btnNght.setOnClickListener {
            msg.text = "GOOD NIGHT"
            notificationManager.notify(notificationId, notification2)
        }
    }

    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                    lightColor = Color.MAGENTA
                    enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }


}
