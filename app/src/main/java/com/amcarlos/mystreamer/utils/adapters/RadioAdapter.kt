package com.amcarlos.mystreamer.utils.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amcarlos.mystreamer.R
import com.amcarlos.mystreamer.databinding.StationItemViewBinding
import com.amcarlos.mystreamer.utils.models.RadioStation


class RadioAdapter(private val station: List<RadioStation>) :
    RecyclerView.Adapter<RadioAdapter.RadioViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.station_item_view, parent, false)
        return RadioViewHolder(view)
    }

    override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
        holder.textViewRadio.text = station[position].stationName
        holder.itemView.setOnClickListener {
        }
    }

    override fun getItemCount(): Int {
        return station.size

    }

    inner class RadioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binder: StationItemViewBinding =
            StationItemViewBinding.inflate(LayoutInflater.from(itemView.context))
        val textViewRadio: TextView = binder.textViewName

    }


}