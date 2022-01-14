package com.example.viewpager2biometricauthentication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpager2biometricauthentication.adapter.ViewPagerAdapter
import com.example.viewpager2biometricauthentication.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {
    private lateinit var binding: FragmentViewPagerBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = setItemList()
        viewPagerAdapter = ViewPagerAdapter(list)
        binding.viewPager.adapter = viewPagerAdapter
    }


    private fun setItemList(): List<String> {

        val url1 =
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/133.png"
        val url2 =
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png"
        val url3 =
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png"
        val url4 =
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/039.png"
        val url5 =
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png"


        var itemList = listOf(url1, url2, url3, url4, url5)

        return itemList

    }

}