package com.example.beokweather.util

import android.location.LocationManager
import com.example.beokweather.model.CoordModel

object LocationUtil {

    fun getCoordinate(locationManager: LocationManager): Result<CoordModel> {
        return try {
            val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)?.run {
                this
            } ?: locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            Result.Success(
                CoordModel(
                    lon = location?.longitude ?: 0.0,
                    lat = location?.latitude ?: 0.0
                )
            )
        } catch (e: SecurityException) {
            Result.Failure(e)
        }
    }
}

