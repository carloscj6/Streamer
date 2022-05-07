package com.amcarlos.mystreamer.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amcarlos.mystreamer.R
import com.amcarlos.mystreamer.databinding.ActivityMainBinding
import com.amcarlos.mystreamer.utils.adapters.RadioAdapter
import com.amcarlos.mystreamer.utils.models.RadioStation
import com.amcarlos.mystreamer.utils.playerutils.StreamerEvents
import org.greenrobot.eventbus.EventBus

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        propagateList()
        handleControls()
    }

    private fun propagateList() {

        val radioList = arrayListOf<RadioStation>()
        for (i in 1..20) {
            val station = RadioStation()
            station.stationName = "Radio Number $i"
            radioList.add(station)
        }
        val adapter = RadioAdapter(radioList)
        activityMainBinding.radioRecyclerView.adapter = adapter
    }
    private fun handleControls(){
        activityMainBinding.playPauseBtn.setOnClickListener {
            EventBus.getDefault().post(StreamerEvents.PLAY)
        }
    }
}