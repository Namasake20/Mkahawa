package com.namasake.mkahawa.framework.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.namasake.mkahawa.business.domain.model.Restaurant
import com.namasake.mkahawa.databinding.RestaurantItemBinding

class RestaurantAdapter: ListAdapter<Restaurant, RestaurantAdapter.RestaurantViewHolder>(RestaurantComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding = RestaurantItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null){
            holder.bind(currentItem)

        }
    }

    class RestaurantViewHolder(private val binding: RestaurantItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(restaurant: Restaurant){
            binding.apply {
                Glide.with(itemView).load(restaurant.logo).into(ImageLogo)
                tvName.text = restaurant.name
                tvType.text = restaurant.type
                tvAddress.text = restaurant.address
            }
        }
    }

    class RestaurantComparator: DiffUtil.ItemCallback<Restaurant>(){
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant) = oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean =
            oldItem == newItem

    }
}