package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.data.Notification

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val listItems = getNotification()

        val notificationRv = findViewById<RecyclerView>(R.id.rvNotification)


        val notificationAdapter: NotificationAdapter = NotificationAdapter()
        notificationAdapter.setListNotification(listItems)

        notificationRv.adapter = notificationAdapter
        notificationRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        notificationRv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    }


    fun getNotification(): List<Notification>{
        val list: MutableList<Notification> = ArrayList()
        list.add(Notification(1,"notification1", "msg1"))
        list.add(Notification(2,"notification2", "msg1"))
        list.add(Notification(3,"notification3", "msg1"))
        for(i in 4..10){
            list.add(Notification(i,"notification $i", "msg $i"))
        }
        return list
    }
}
