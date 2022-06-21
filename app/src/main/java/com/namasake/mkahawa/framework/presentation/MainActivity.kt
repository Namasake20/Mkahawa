package com.namasake.mkahawa.framework.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.namasake.mkahawa.business.domain.state.DataState
import com.namasake.mkahawa.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantAdapter = RestaurantAdapter()
        viewModel.setStateEvent(MainStateEvent.GetRestaurantsEvent)

        binding.apply {
            recyclerView.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
                viewModel.dataState.observe(this@MainActivity){ result ->
                    progressBar.isVisible = result is DataState.Loading
                    tvError.isVisible = result is DataState.Error

                }

            }
        }
    }


}