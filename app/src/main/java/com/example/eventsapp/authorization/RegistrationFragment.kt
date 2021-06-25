package com.example.eventsapp.authorization

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.eventsapp.R
import com.example.eventsapp.data.base.BaseFragment
import com.example.eventsapp.databinding.FragmentRegistrationBinding
import com.example.eventsapp.ui.main.MainActivity
import com.example.eventsapp.utils.viewBinding


class RegistrationFragment : BaseFragment() {
    override fun resID() = R.layout.fragment_registration

    private val binding by viewBinding(FragmentRegistrationBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
            requireActivity().finish()
        }
    }

//    private fun saveData(){
//        val name = binding.etName.text.toString()
//        PreferenceHelper.setName(name)
//
//        val phoneNumber = binding.etPhoneNumber.text.toString()
//        PreferenceHelper.setPhoneNumber(phoneNumber)
//
//        val email = binding.etEmail.text.toString()
//        PreferenceHelper.setEmail(email)
//
//        val password = binding.etPassword.text.toString()
//        PreferenceHelper.setPassword(password)
//
//        val repeatPassword = binding.etRepeatPassword.text.toString()
//        PreferenceHelper.setRepeatPassword(repeatPassword)
//    }
}