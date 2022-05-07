package com.amcarlos.mystreamer.utils.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amcarlos.mystreamer.R
import com.amcarlos.mystreamer.utils.models.RadioStation
import com.amcarlos.mystreamer.utils.viewholders.RadioViewHolder

class RadioAdapter(private val station: List<RadioStation>) :
    RecyclerView.Adapter<RadioViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.station_item_view, parent, false)
        return RadioViewHolder(view)
    }

    override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
        holder.textViewRadio.text = station[position].stationName
    }

    override fun getItemCount(): Int {
        return station.size

    }

}