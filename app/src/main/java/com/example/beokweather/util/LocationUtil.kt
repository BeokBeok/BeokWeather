package com.example.beokweather.util

import android.location.LocationManager
import com.example.beokweather.model.CoordModel

object LocationUtil {

    fun getCoordinate(locationManager: LocationManager): Result<CoordModel> {
        return try {
            val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)?.run {
                this
            } ?: locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            Result.Success(CoordModel(lon = location.longitude, lat = location.latitude))
        } catch (e: SecurityException) {
            Result.Failure(e)
        }
    }
}

