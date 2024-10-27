package com.example.findmyservicep2

import android.os.Bundle
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

// Define ServiceCategory data class at the top of the file
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
            // Add more categories as needed
        )

        // Set up RecyclerView with a GridLayoutManager and the adapter
        categoryRecyclerView.layoutManager = GridLayoutManager(this, 2) // Display 2 columns
        categoryRecyclerView.adapter = ServiceCategoryAdapter(categories) { category ->
            // Handle item click
            // e.g., navigate to a detail screen or start a new activity with the selected category
        }

        // Set click listener for the Post Request button
        postRequestButton.setOnClickListener {
            // Logic to handle posting a service request
        }
    }
}

// Define ServiceCategoryAdapter class here
class ServiceCategoryAdapter(
    private val categories: List<ServiceCategory>,
    private val onItemClick: (ServiceCategory) -> Unit
) : RecyclerView.Adapter<ServiceCategoryAdapter.CategoryViewHolder>() {

    // ViewHolder class to hold item views
    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val icon: ImageView = view.findViewById(R.id.categoryIcon)
        private val name: TextView = view.findViewById(R.id.categoryName)

        fun bind(category: ServiceCategory) {
            icon.setImageResource(category.iconResId) // Set icon image
            name.text = category.name // Set category name
            itemView.setOnClickListener { onItemClick(category) } // Handle item click
        }
    }

    // Inflate the item layout and create the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_service_category, parent, false)
        return CategoryViewHolder(view)
    }

    // Bind data to the ViewHolder
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position]) // Bind the current category to the ViewHolder
    }

    // Return the total count of items
    override fun getItemCount(): Int = categories.size
}


