package com.codechacha.sample.step4

import android.annotation.SuppressLint
import android.content.Context
import android.location.LocationListener
import android.location.LocationManager
import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

object BoundLocationManager {
    fun bindLocationListenerIn(
        lifecycleOwner: LifecycleOwner,
        listener: LocationListener, context: Context
    ) {
        BoundLocationListener(lifecycleOwner, listener, context)
    }

    internal class BoundLocationListener(
        lifecycleOwner: LifecycleOwner,
        private val mListener: LocationListener, private val mContext: Context
    )//TODO: Add lifecycle observer
        : LifecycleObserver {
        private var mLocationManager: LocationManager? = null

        @SuppressLint("MissingPermission")
        fun addLocationListener() {
            // Note: Use the Fused Location Provider from Google Play Services instead.
            // https://developers.google.com/android/reference/com/google/android/gms/location/FusedLocationProviderApi

            mLocationManager = mContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            mLocationManager!!.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, mListener)
            Log.d("BoundLocationMgr", "Listener added")

            // Force an update with the last location, if available.
            val lastLocation = mLocationManager!!.getLastKnownLocation(
                LocationManager.GPS_PROVIDER
            )
            if (lastLocation != null) {
                mListener.onLocationChanged(lastLocation)
            }
        }

        //TODO: Call this on pause
        fun removeLocationListener() {
            if (mLocationManager == null) {
                return
            }
            mLocationManager!!.removeUpdates(mListener)
            mLocationManager = null
            Log.d("BoundLocationMgr", "Listener removed")
        }
    }
}
