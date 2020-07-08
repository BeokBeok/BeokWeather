package com.example.beokweather.splash

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.beokweather.R
import com.example.beokweather.ext.isNotValidLocationPermission
import com.example.beokweather.ext.startActivity
import com.example.beokweather.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigateAccordingToPermission()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (isNotValidLocationPermission()) {
            showLocationPermissionDialog()
        } else {
            startActivity<MainActivity>()
        }
    }

    private fun navigateAccordingToPermission() {
        if (isNotValidLocationPermission()) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                0
            )
        } else {
            startActivity<MainActivity>()
        }
    }

    private fun showLocationPermissionDialog() {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title_permission_settings))
            .setMessage(getString(R.string.msg_unavailable_app_because_permission_denied))
            .setPositiveButton(getString(R.string.label_go_permission_settings)) { _, _ ->
                try {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                        .setData(Uri.parse("package:$packageName"))
                    startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    val intent = Intent(Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS)
                    startActivity(intent)
                }
            }
            .setNegativeButton(getString(R.string.label_cancel)) { _, _ ->
                Toast.makeText(this, getString(R.string.msg_app_finish), Toast.LENGTH_SHORT).show()
                finish()
            }
            .create()
            .show()
    }
}