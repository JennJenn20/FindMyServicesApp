package com.example.findmyservicep2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ServiceCategoryAdapter (

        private val categories: List<ServiceCategory>,
        private val onItemClick: (ServiceCategory) -> Unit
    ) : RecyclerView.Adapter<ServiceCategoryAdapter.CategoryViewHolder>() {

        inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            private val icon: ImageView = view.findViewById(R.id.categoryIcon)
            private val name: TextView = view.findViewById(R.id.categoryName)

            fun bind(category: ServiceCategory) {
                icon.setImageResource(category.iconResId) // Set icon image
                name.text = category.name // Set category name
                itemView.setOnClickListener { onItemClick(category) } // Handle item click
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_service_category, parent, false)
            return CategoryViewHolder(view)
        }

        override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
            holder.bind(categories[position]) // Bind the current category to the ViewHolder
        }

        override fun getItemCount(): Int = categories.size
    }

