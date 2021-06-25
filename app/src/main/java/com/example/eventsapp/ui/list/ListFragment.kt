package com.example.eventsapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.eventsapp.R
import com.example.eventsapp.data.base.BaseFragment
import com.example.eventsapp.data.model.ViewPagerModel
import com.example.eventsapp.databinding.FragmentListBinding
import com.example.eventsapp.utils.viewBinding
import com.google.android.material.tabs.TabLayoutMediator

class ListFragment : BaseFragment() {
    override fun resID() = R.layout.fragment_list
    private var adapter: PagerAdapter? = null
    private val binding by viewBinding(FragmentListBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.title = "Актуальные события"
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        adapter = PagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = false
        adapter?.update(getDataForViewPager())

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            tab.text = adapter?.getCurrentItem(pos)?.title
        }.attach()

    }

    private fun getDataForViewPager(): ArrayList<ViewPagerModel> {
        val list = arrayListOf<ViewPagerModel>()
        list.add(ViewPagerModel(OrganizationsFragment(), "Организации"))
        list.add(ViewPagerModel(PeopleFragment(), "Люди"))

        return list
    }
}