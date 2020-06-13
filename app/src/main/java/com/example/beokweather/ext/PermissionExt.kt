package com.example.beokweather.ext

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

fun Context.isNotValidLocationPermission(): Boolean {
    val checkAccessFineLocationPermission = ActivityCompat.checkSelfPermission(
        this,
        android.Manifest.permission.ACCESS_FINE_LOCATION
    )
    val checkAccessCoarseLocationPermission = ActivityCompat.checkSelfPermission(
        this,
        android.Manifest.permission.ACCESS_COARSE_LOCATION
    )

    return checkAccessFineLocationPermission != PackageManager.PERMISSION_GRANTED &&
            checkAccessCoarseLocationPermission != PackageManager.PERMISSION_GRANTED
}