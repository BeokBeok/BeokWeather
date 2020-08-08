package com.example.beokweather.main

import android.location.LocationManager
import android.os.Bundle
import android.util.ArrayMap
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.beokweather.BR
import com.example.beokweather.R
import com.example.beokweather.databinding.ActivityMainBinding
import com.example.beokweather.detail.DetailActivity
import com.example.beokweather.main.model.Forecast
import com.example.beokweather.util.LocationUtil
import com.example.common.base.BaseActivity
import com.example.common.base.BaseAdapter
import com.example.common.base.ViewModelBindComponent
import com.example.common.ext.isNotValidLocationPermission
import com.example.common.ext.startActivity
import com.example.common.type.Result
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(layoutId = R.layout.activity_main) {

    private val viewModel by viewModels<MainViewModel>()
    private val viewModelBindComponent = ViewModelBindComponent()

    @Inject
    lateinit var locationManager: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (checkLocationPermission()) return
        setupBinding()
        setupRecyclerView()
        showContents()
    }

    private fun setupBinding() {
        viewModelBindComponent.run {
            bindViewModel {
                binding.vm = viewModel
            }
            bindObserver {
                setupObserve()
            }
        }
    }

    private fun setupObserve() {
        val owner = this@MainActivity
        viewModel.run {
            errMsg.observe(owner, Observer {
                Toast.makeText(owner, it, Toast.LENGTH_SHORT).show()
            })
            selectedItem.observe(owner, Observer { weatherItem ->
                startActivity<DetailActivity>(bundleOf("item" to weatherItem))
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
            })
        }
    }

    private fun setupRecyclerView() {
        binding.rvMainContents.adapter =
            BaseAdapter<Forecast>(
                layoutBindingId = Pair(R.layout.item_weather, BR.weather_item),
                viewModels = ArrayMap<Int, ViewModel>().apply {
                    put(BR.vm, viewModel)
                }
            )
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
        when (val coordinate = LocationUtil.getCoordinate(locationManager)) {
            is Result.Success -> {
                viewModel.getWeather(coordinate.data.lat, coordinate.data.lon)
            }
            is Result.Failure -> {
                Toast.makeText(this, coordinate.exception.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}