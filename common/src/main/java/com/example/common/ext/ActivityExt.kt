package com.example.common.ext

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat

inline fun <reified T : Activity> Activity.startActivity(bundle: Bundle? = null) {
    val intent = Intent(this, T::class.java)
    if (bundle != null) {
        intent.putExtras(bundle)
    }
    startActivity(intent)
}

fun Activity.isNotValidLocationPermission(): Boolean {
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