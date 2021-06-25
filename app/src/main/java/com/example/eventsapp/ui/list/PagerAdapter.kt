package com.example.eventsapp.ui.list

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.eventsapp.data.model.ViewPagerModel

class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    var dataForPager = arrayListOf<ViewPagerModel>()

    override fun getItemCount() = dataForPager.size

    override fun createFragment(position: Int) = dataForPager[position].fragment

    fun update(dataForPager: ArrayList<ViewPagerModel>) {
        this.dataForPager = dataForPager
        notifyDataSetChanged()
    }

    fun getCurrentItem(position: Int) = dataForPager[position]
}
