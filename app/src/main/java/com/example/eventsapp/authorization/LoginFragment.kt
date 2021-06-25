package com.example.eventsapp.authorization

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.eventsapp.data.base.BaseEvent
import com.example.eventsapp.data.base.BaseFragment
import com.example.eventsapp.data.base.BaseViewModel
import com.example.eventsapp.data.local.PreferenceHelper
import com.example.eventsapp.databinding.FragmentLoginBinding
import com.example.eventsapp.databinding.FragmentProfileBinding
import com.example.eventsapp.ui.main.MainActivity

class LoginViewModel : BaseViewModel<BaseEvent>()

class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>(
    LoginViewModel::class
) {


    override fun setupViews() {
        setupListeners()
    }

    override fun subscribeToLiveData() {

    }

    override fun attachBinding(
        list: MutableList<FragmentLoginBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(FragmentLoginBinding.inflate(layoutInflater, container, attachToRoot))
    }

    private fun setupListeners() {
        binding.btnRegistration.setOnClickListener {
            navigateToRegistration()
        }

        binding.btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {

        val login = binding.etLogin.text.toString()
        val password = binding.etPassword.text.toString()

        val loginFromPref = PreferenceHelper.getName().toString()
        val passwordFromPref = PreferenceHelper.getPassword().toString()

        if (loginFromPref == login && passwordFromPref == password) {
            startActivity(Intent(activity, MainActivity::class.java))
            requireActivity().finish()
        } else {
            Toast.makeText(activity, "Логин или пароль не верны", Toast.LENGTH_LONG).show()
        }
    }

    private fun navigateToRegistration() {
        val destination = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
        findNavController().navigate(destination)
    }

}