package com.example.eventsapp.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.eventsapp.R
import com.example.eventsapp.data.base.BaseViewHolder
import com.example.eventsapp.data.model.PersonalEventModel
import com.example.eventsapp.utils.diffUtils.DiffUtilsEvent

class EventsAdapter : ListAdapter<PersonalEventModel, EventViewHolder>(DiffUtilsEvent.diffUtilEvent) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_events_list, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class EventViewHolder(itemView: View) : BaseViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.title)
    private val image: ImageView = itemView.findViewById(R.id.image)

    fun bind(item: PersonalEventModel) {
        title.text = item.title

        Glide
            .with(image.context)
            .load(item.image)
            .centerCrop()
            .into(image)
    }
}
