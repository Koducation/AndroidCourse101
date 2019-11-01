package com.koducation.androidcourse101.player

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import javax.inject.Inject

class PlayerViewModel @Inject constructor(val app: Application) : AndroidViewModel(app) {

    private val playerViewStateLiveData = MutableLiveData<PlayerViewState>()

    private val mediaPlayer = ExoPlayerFactory.newSimpleInstance(app.applicationContext)

    private val dataSourceFactory = DefaultDataSourceFactory(app.applicationContext, getUserAgent())

    private var currentUri: Uri? = null

    init {
        mediaPlayer.addListener(object : Player.EventListener {
            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                val playerState = when {
                    playbackState == ExoPlayer.STATE_READY && mediaPlayer.playWhenReady -> PlayerState.PLAYING
                    playbackState == ExoPlayer.STATE_READY && mediaPlayer.playWhenReady.not() -> PlayerState.PAUSED
                    playbackState == ExoPlayer.STATE_BUFFERING -> PlayerState.BUFFERING
                    else -> PlayerState.ERROR
                }

                playerViewStateLiveData.value = PlayerViewState(playerState)
            }

            override fun onPlayerError(error: ExoPlaybackException?) {
                playerViewStateLiveData.value = PlayerViewState(PlayerState.ERROR)
            }
        })
    }

    fun getPlayerViewStateLiveData(): LiveData<PlayerViewState> {
        return playerViewStateLiveData
    }

    fun start(uri: Uri) {
        if (uri == currentUri) {
            return
        }

        currentUri = uri
        val mediaSource = createMediaSource(uri)
        mediaPlayer.playWhenReady = true
        mediaPlayer.prepare(mediaSource)
    }

    fun resume() {
        mediaPlayer.playWhenReady = true
    }

    fun stop() {
        mediaPlayer.playWhenReady = false
    }

    fun isPlaying() =
        mediaPlayer.playbackState == ExoPlayer.STATE_READY && mediaPlayer.playWhenReady

    override fun onCleared() {
        super.onCleared()
        mediaPlayer.stop()
        mediaPlayer.release()
    }

    private fun createMediaSource(uri: Uri): MediaSource {
        return ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
    }

    private fun getUserAgent(): String {
        return Util.getUserAgent(app.applicationContext, "spotifyRadioApp")
    }
}