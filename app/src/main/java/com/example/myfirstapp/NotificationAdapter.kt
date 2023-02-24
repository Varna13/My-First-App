package com.example.myfirstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myfirstapp.data.Notification

class NotificationAdapter: Adapter<NotificationAdapter.NotificationViewHolder>() {

    private lateinit var listNotification:List<Notification>

    //setter- for calling the variable in another class
    fun setListNotification(listNotification: List<Notification>){
        this.listNotification = listNotification
    }

    inner class NotificationViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_notification, parent, false
        ))
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val tvNotificationTitle = holder.itemView.findViewById<TextView>(R.id.tvTitle)
        val tvNotificationMessage = holder.itemView.findViewById<TextView>(R.id.tvMessage)
        val notification = listNotification[position]
        tvNotificationTitle.text = notification.title
        tvNotificationMessage.text = notification.message
    }

    override fun getItemCount(): Int {
        return listNotification.size
    }
}
