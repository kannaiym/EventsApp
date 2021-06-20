package com.example.eventsapp.ui.profile

import android.os.Bundle
import android.view.View
import com.example.eventsapp.R
import com.example.eventsapp.data.base.BaseFragment
import com.example.eventsapp.data.model.getCourses
import com.example.eventsapp.databinding.FragmentProfileBinding
import com.example.eventsapp.utils.viewBinding

class ProfileFragment: BaseFragment() {
    override fun resID() = R.layout.fragment_profile
    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val eventAdapter by lazy {
        PersonalEventsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvOwnEvents.adapter = eventAdapter
        eventAdapter.submitList(getCourses())
    }
}