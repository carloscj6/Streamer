package com.amcarlos.mystreamer.services

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.media.session.MediaSession
import android.net.Uri
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import com.amcarlos.mystreamer.utils.playerutils.StaticItems
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

    @RequiresApi(Build.VERSION_CODES.O)
    @Subscribe(threadMode = ThreadMode.MAIN)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(StaticItems.NOTIFICATION_ID,notification)
        mediaPlayer?.apply {
            setDataSource(this@RadioPlayerService, Uri.parse(stationLink))
            setOnPreparedListener(this@RadioPlayerService)
            prepareAsync()
        }

        return START_STICKY
    }

    override fun onDestroy() {
        mediaPlayer?.release()
        EventBus.getDefault().unregister(this)
    }

    override fun onPrepared(p0: MediaPlayer?) {
        mediaPlayer?.start()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private val notification= Notification.Builder(this,"Radio")
        .setSubText("Radio Playing")
        .setContentTitle("HomeBoyz Radio")
        .setStyle(Notification.MediaStyle())
        .build()
    private val session= MediaSession(this,"Radio")

    inner class PlayerBinder : Binder() {
        fun getService(): RadioPlayerService = this@RadioPlayerService
    }
}