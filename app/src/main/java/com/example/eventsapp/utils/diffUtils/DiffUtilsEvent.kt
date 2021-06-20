package com.example.eventsapp.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.eventsapp.data.model.PersonalEventModel

object DiffUtilsEvent {

    val diffUtilEvent = object : DiffUtil.ItemCallback<PersonalEventModel>() {
        override fun areItemsTheSame(oldItem: PersonalEventModel, newItem: PersonalEventModel): Boolean {
            return oldItem.image == newItem.image
                    && oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: PersonalEventModel, newItem: PersonalEventModel): Boolean {
            return oldItem == newItem
        }
    }
}