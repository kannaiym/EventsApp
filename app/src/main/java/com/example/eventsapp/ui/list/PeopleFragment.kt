package com.example.eventsapp.ui.list

import android.os.Bundle
import android.view.View
import com.example.eventsapp.R
import com.example.eventsapp.data.base.BaseFragment
import com.example.eventsapp.data.model.getCourses
import com.example.eventsapp.databinding.FragmentPeopleBinding
import com.example.eventsapp.utils.viewBinding

class PeopleFragment: BaseFragment() {
    override fun resID() = R.layout.fragment_people
    private val binding by viewBinding(FragmentPeopleBinding::bind)
    private val eventAdapter by lazy {
        EventsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvFragmentPeople.adapter = eventAdapter
        eventAdapter.submitList(getCourses())
    }
}