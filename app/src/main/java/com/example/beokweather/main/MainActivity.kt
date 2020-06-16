package com.example.beokweather.main

import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.collection.arrayMapOf
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.beokweather.BR
import com.example.beokweather.R
import com.example.beokweather.base.BaseActivity
import com.example.beokweather.base.BaseAdapter
import com.example.beokweather.base.type.Result
import com.example.beokweather.base.type.isSuccess
import com.example.beokweather.databinding.ActivityMainBinding
import com.example.beokweather.detail.DetailActivity
import com.example.beokweather.ext.isNotValidLocationPermission
import com.example.beokweather.ext.startActivity
import com.example.beokweather.main.model.Forecast
import com.example.beokweather.util.LocationUtil
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(
    layoutId = R.layout.activity_main
) {
    private val viewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var locationManager: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (checkLocationPermission()) return
        setupRecyclerView()
        showContents()
    }

    override fun bindViewModel() {
        binding.vm = viewModel
    }

    override fun setupObserve() {
        val owner = this
        viewModel.run {
            errMsg.observe(owner, Observer {
                Toast.makeText(owner, it, Toast.LENGTH_SHORT).show()
            })
            selectedItem.observe(owner, Observer {
                it.getContentIfNotHandled()?.let { weatherItem ->
                    startActivity<DetailActivity>(bundleOf("item" to weatherItem))
                    overridePendingTransition(0, 0)
                }
            })
        }
    }

    private fun setupRecyclerView() {
        binding.rvMainContents.adapter = BaseAdapter<Forecast>(
            layoutBindingId = Pair(R.layout.item_weather, BR.weather_item),
            viewModels = arrayMapOf(BR.vm to viewModel)
        )
        PagerSnapHelper().attachToRecyclerView(binding.rvMainContents)
    }

    private fun checkLocationPermission(): Boolean {
        if (isNotValidLocationPermission()) {
            Toast.makeText(
                this,
                R.string.msg_unavailable_app_because_permission_denied,
                Toast.LENGTH_SHORT
            ).show()
            return true
        }
        return false
    }

    private fun showContents() {
        val coordinate = LocationUtil.getCoordinate(locationManager)
        if (coordinate.isSuccess) {
            val data = (coordinate as Result.Success).data
            viewModel.getWeather(data.lat, data.lon)
        } else {
            val exception = (coordinate as Result.Failure).exception
            Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
        }
    }
}