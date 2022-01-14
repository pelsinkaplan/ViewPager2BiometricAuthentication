package com.example.viewpager2biometricauthentication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewpager2biometricauthentication.databinding.ItemViewPagerBinding

class ViewPagerAdapter(private val itemList: List<String>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: ItemViewPagerBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        var binding: ItemViewPagerBinding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        val design = ItemViewPagerBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(design)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList.get(position)

        Glide.with(holder.itemView.context).load(item)
            .into(holder.binding.imageView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}