package com.example.beokweather.detail

import android.os.Bundle
import androidx.activity.viewModels
import com.example.beokweather.BR
import com.example.beokweather.R
import com.example.beokweather.base.BaseActivity
import com.example.beokweather.base.BaseAdapter
import com.example.beokweather.databinding.ActivityDetailBinding
import com.example.beokweather.main.model.WeatherItem
import com.example.beokweather.model.ListItemModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding>(
    layoutId = R.layout.activity_detail
) {

    private val viewModel by viewModels<DetailViewModel>()

    override fun bindViewModel() {
        binding.vm = viewModel.apply {
            setupItem((intent.extras?.get("item") as? WeatherItem) ?: WeatherItem())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.rvDetailForecast.adapter = BaseAdapter<ListItemModel>(
            layoutBindingId = Pair(R.layout.item_weather_forecast, BR.item)
        )
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(0, 0)
    }
}