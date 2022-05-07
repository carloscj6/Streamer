package com.amcarlos.mystreamer.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Binder
import android.os.IBinder
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class RadioPlayerService : Service(), MediaPlayer.OnPreparedListener {
    private var mediaPlayer: MediaPlayer? = null
    private val stationLink = "http://91.121.165.88:8116/stream/1/"
    override fun onBind(p0: Intent?): IBinder {
        return PlayerBinder()
    }

    override fun onCreate() {
        mediaPlayer = MediaPlayer()
        EventBus.getDefault().register(this)
        super.onCreate()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer?.apply {
            setDataSource(this@RadioPlayerService, Uri.parse(stationLink))
            setOnPreparedListener(this@RadioPlayerService)
            prepareAsync()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        mediaPlayer?.release()
        EventBus.getDefault().unregister(this)
    }

    override fun onPrepared(p0: MediaPlayer?) {
        mediaPlayer?.start()
    }

    inner class PlayerBinder : Binder() {
        fun getService(): RadioPlayerService = this@RadioPlayerService
    }
}