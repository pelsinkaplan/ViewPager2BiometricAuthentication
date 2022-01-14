package com.example.viewpager2biometricauthentication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.viewpager2biometricauthentication.R
import com.example.viewpager2biometricauthentication.databinding.FragmentFirstBinding
import com.example.viewpager2biometricauthentication.databinding.FragmentViewPagerBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.firstFragmentButton.setOnClickListener{
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(binding.firstFragmentEditText.text.toString())
            view.findNavController().navigate(action)
        }
    }

}