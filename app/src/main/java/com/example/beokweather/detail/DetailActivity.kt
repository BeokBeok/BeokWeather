package com.example.beokweather.detail

import android.os.Bundle
import androidx.activity.viewModels
import com.example.beokweather.BR
import com.example.beokweather.R
import com.example.beokweather.databinding.ActivityDetailBinding
import com.example.beokweather.main.model.ListItem
import com.example.beokweather.main.model.WeatherItem
import com.example.common.base.BaseActivity
import com.example.common.base.BaseAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding>(layoutId = R.layout.activity_detail) {

    private val viewModel by viewModels<DetailViewModel>()

    override fun bindViewModel() {
        binding.vm = viewModel.apply {
            setupItem((intent.extras?.get("item") as? WeatherItem) ?: WeatherItem())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupToolbar()
        setupRecyclerView()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left)
    }

    private fun setupToolbar() {
        binding.tbDetailToolbar.run {
            setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
            setOnClickListener { finish() }
        }
    }

    private fun setupRecyclerView() {
        binding.rvDetailForecast.adapter =
            BaseAdapter<ListItem>(
                layoutBindingId = Pair(R.layout.item_weather_forecast, BR.item)
            )
    }
}