package com.koducation.androidcourse101.player

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.koducation.androidcourse101.R
import com.koducation.androidcourse101.player.PlayerState.*

data class PlayerViewState(val playerState: PlayerState) {

    fun getPlayerStateText(context: Context): String {
        return when (playerState) {
            PLAYING -> context.getString(R.string.player_status_now_playing)
            BUFFERING -> context.getString(R.string.player_status_buffering)
            PAUSED -> context.getString(R.string.player_status_paused)
            ERROR -> context.getString(R.string.player_status_error)
        }
    }

    fun getPlayPauseIcon(context: Context): Drawable? {
        return when (playerState) {
            PLAYING -> ContextCompat.getDrawable(context, R.drawable.ic_pause)
            else -> ContextCompat.getDrawable(context, R.drawable.ic_play)
        }
    }

    fun getPlayPauseIconClicable(): Boolean {
        return when (playerState) {
            PLAYING -> true
            PAUSED -> true
            else -> false
        }
    }
}