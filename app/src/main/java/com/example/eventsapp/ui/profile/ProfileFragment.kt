package com.example.eventsapp.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.eventsapp.data.base.BaseFragment
import com.example.eventsapp.data.model.getCourses
import com.example.eventsapp.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>(
    ProfileViewModel::class
) {

    private val eventAdapter by lazy {
        PersonalEventsAdapter {
            navigateToProductDetails()
        }
    }

    override fun setupViews() {
        setupRecyclerView()
    }

    override fun subscribeToLiveData() {
        viewModel.userData.observe(viewLifecycleOwner, Observer {
            eventAdapter.submitList(getCourses())
        })
    }

    override fun attachBinding(
        list: MutableList<FragmentProfileBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(FragmentProfileBinding.inflate(layoutInflater, container, attachToRoot))
    }

    private fun setupRecyclerView() {
        binding.rvOwnEvents.adapter = eventAdapter
    }

    private fun navigateToProductDetails() {
        val destination = ProfileFragmentDirections.actionProfileFragmentToDetailFragment()
        findNavController().navigate(destination)
    }

}