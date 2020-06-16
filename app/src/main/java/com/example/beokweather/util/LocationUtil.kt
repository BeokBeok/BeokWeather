package com.example.beokweather.util

import android.location.LocationManager
import com.example.beokweather.base.type.Result
import com.example.beokweather.main.model.Coord

object LocationUtil {

    fun getCoordinate(locationManager: LocationManager): Result<Coord> =
        try {
            val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)?.run {
                this
            } ?: locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            Result.Success(
                Coord(
                    lon = location?.longitude ?: 0.0,
                    lat = location?.latitude ?: 0.0
                )
            )
        } catch (e: SecurityException) {
            Result.Failure(e)
        }
}

