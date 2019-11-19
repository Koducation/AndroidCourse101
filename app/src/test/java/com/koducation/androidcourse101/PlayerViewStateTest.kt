package com.koducation.androidcourse101

import com.google.common.truth.Truth
import com.koducation.androidcourse101.player.PlayerState
import com.koducation.androidcourse101.player.PlayerViewState
import org.junit.Test

class PlayerViewStateTest {

    @Test
    fun `given player PLAYING state, when getPlayPauseIconClicable is called, then return true`() {

        // Given
        val playerState = PlayerState.PLAYING
        val givenViewState = PlayerViewState(playerState)

        // When
        val actualResult = givenViewState.getPlayPauseIconClicable()

        // Then
        Truth.assertThat(actualResult).isTrue()
    }

    @Test
    fun `given player PAUSED state, when getPlayPauseIconClicable is called, then return true`() {

        // Given
        val playerState = PlayerState.PAUSED
        val givenViewState = PlayerViewState(playerState)

        // When
        val actualResult = givenViewState.getPlayPauseIconClicable()

        // Then
        Truth.assertThat(actualResult).isTrue()
    }

    @Test
    fun `given player ERROR state, when getPlayPauseIconClicable is called, then return false`() {

        // Given
        val playerState = PlayerState.ERROR
        val givenViewState = PlayerViewState(playerState)

        // When
        val actualResult = givenViewState.getPlayPauseIconClicable()

        // Then
        Truth.assertThat(actualResult).isFalse()
    }

    @Test
    fun `given player BUFFERING state, when getPlayPauseIconClicable is called, then return false`() {

        // Given
        val playerState = PlayerState.BUFFERING
        val givenViewState = PlayerViewState(playerState)

        // When
        val actualResult = givenViewState.getPlayPauseIconClicable()

        // Then
        Truth.assertThat(actualResult).isFalse()
    }
}