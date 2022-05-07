package com.amcarlos.mystreamer.utils.playerutils

import android.app.Service
import android.media.MediaPlayer

abstract class RadioStreamer : MediaPlayer() {
    lateinit var radioStreamerService: Service
    override fun setOnPreparedListener(listener: OnPreparedListener?) {
        super.setOnPreparedListener(listener)
    }

    fun setService(playerService: Service) {
        radioStreamerService = playerService
    }
}