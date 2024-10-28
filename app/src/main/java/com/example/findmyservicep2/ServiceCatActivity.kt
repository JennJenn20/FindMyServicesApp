package com.example.findmyservicep2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class ServiceCategory(
    val name: String,
    val iconResId: Int
)

class ServiceCatActivity : AppCompatActivity() {

    private lateinit var searchBar: EditText
    private lateinit var categoryRecyclerView: RecyclerView
    private lateinit var postRequestButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicecat)

        // Initialize views
        searchBar = findViewById(R.id.searchBar)
        categoryRecyclerView = findViewById(R.id.categoryRecyclerView)
        postRequestButton = findViewById(R.id.postRequestButton)

        // Sample data for service categories
        val categories = listOf(
            ServiceCategory("Cleaning Services", R.drawable.cleaning_service_icon),
            ServiceCategory("House Call Hairstylist", R.drawable.hair_service_icon),
            ServiceCategory("Painting Services", R.drawable.painting_services),
            ServiceCategory("Electrical Services", R.drawable.tools)
        )

        categoryRecyclerView.layoutManager = GridLayoutManager(this, 2) // Display 2 columns
        categoryRecyclerView.adapter = ServiceCategoryAdapter(categories) { category ->

         Log.d("ServiceCatActivity", "Clicked on category: ${category.name}")

            // Start LocationSearchActivity when a category is clicked
            val intent = Intent(this, LocationSearchActivity::class.java)
            intent.putExtra("SELECTED_CATEGORY", category.name)
            startActivity(intent)
        }

        // Set click listener for the Post Request button
        postRequestButton.setOnClickListener {
            // Logic to handle posting a service request
        }
    }
}


