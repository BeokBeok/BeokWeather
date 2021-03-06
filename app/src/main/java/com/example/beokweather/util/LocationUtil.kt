package com.example.beokweather.util

import android.location.LocationManager
import com.example.beokweather.main.model.Coord
import com.example.common.type.Result

object LocationUtil {

    fun getCoordinate(locationManager: LocationManager): Result<Coord> =
        try {
            val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                ?: locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            Result.Success(Coord(lon = location?.longitude ?: 0.0, lat = location?.latitude ?: 0.0))
        } catch (e: SecurityException) {
            Result.Failure(e)
        }
}

