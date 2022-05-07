package com.amcarlos.mystreamer.utils.viewholders

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amcarlos.mystreamer.databinding.StationItemViewBinding

class RadioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var binder: StationItemViewBinding =
        StationItemViewBinding.inflate(LayoutInflater.from(itemView.context))
    val textViewRadio: TextView = binder.textViewName

}