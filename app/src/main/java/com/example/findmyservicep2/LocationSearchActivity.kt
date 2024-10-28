package com.example.findmyservicep2

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class LocationSearchActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private val locationRequestCode = 1 // Updated to camel case

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_search)

        val providersRecyclerView: RecyclerView = findViewById(R.id.providersRecyclerView)
        providersRecyclerView.layoutManager = LinearLayoutManager(this)

        // Retrieve the selected category if passed
        val selectedCategory = intent.getStringExtra("SELECTED_CATEGORY")

        // Find a TextView to display the category (if you have one in your layout)
        val categoryTextView: TextView = findViewById(R.id.selectedCategoryTextView)
        categoryTextView.text = selectedCategory ?: "No Category Selected"

        // Initialize map
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Request location permission
        requestLocationPermission()
    }

    private fun requestLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), locationRequestCode)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == locationRequestCode && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            enableLocationOnMap()
        }
    }

    private fun enableLocationOnMap() {
        if (::mMap.isInitialized) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mMap.isMyLocationEnabled = true
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        enableLocationOnMap() // Call this function to enable location

        // Move camera to a default location (e.g., Cape Town)
        val defaultLocation = LatLng(-33.9258, 18.4232)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 10f))
    }
}



