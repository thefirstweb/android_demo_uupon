package com.sitemaji.uupon

import android.app.Application
import android.util.Log
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener
import java.util.*

class App : Application() {

    companion object {

        const val TAG = "App"
        const val ADID = "009FFEF173A4A86C8B48DDCF7FE1B51A"

    }

    override fun onCreate() {
        super.onCreate()

        /*
        val testDevice = Arrays.asList(ADID)
        val configuration = RequestConfiguration.Builder()
                .setTestDeviceIds(testDevice)
                .build()

        MobileAds.setRequestConfiguration(configuration)
         */

        MobileAds.initialize(this, OnInitializationCompleteListener {
            initializationStatus ->

            Log.d(TAG, initializationStatus.toString())

        })
    }
}