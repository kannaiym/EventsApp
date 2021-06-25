package com.example.eventsapp.ui.list

import android.os.Bundle
import android.view.View
import com.example.eventsapp.R
import com.example.eventsapp.data.base.BaseFragment
import com.example.eventsapp.data.model.getCourses
import com.example.eventsapp.databinding.FragmentOrganizationsBinding
import com.example.eventsapp.utils.viewBinding

class OrganizationsFragment: BaseFragment() {
    override fun resID() = R.layout.fragment_organizations
    private val binding by viewBinding(FragmentOrganizationsBinding::bind)
    private val eventAdapter by lazy {
        EventsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvFragmentOrganizations.adapter = eventAdapter
        eventAdapter.submitList(getCourses())
    }
}