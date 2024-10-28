package com.example.findmyservicep2
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

    class ProvidersAdapter(private val providers: List<Provider>) :
        RecyclerView.Adapter<ProvidersAdapter.ProviderViewHolder>() {

        class ProviderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val name: TextView = view.findViewById(R.id.providerName)
            val rating: TextView = view.findViewById(R.id.providerRating)
            val distance: TextView = view.findViewById(R.id.providerDistance)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProviderViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_provider, parent, false)
            return ProviderViewHolder(view)
        }

        override fun onBindViewHolder(holder: ProviderViewHolder, position: Int) {
            val provider = providers[position]
            holder.name.text = provider.name
            holder.rating.text = "Rating: ${provider.rating}"
            holder.distance.text = "${provider.distance} km away"
        }

        override fun getItemCount(): Int = providers.size
    }
