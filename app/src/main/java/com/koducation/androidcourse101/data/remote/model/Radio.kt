package com.koducation.androidcourse101.data.remote.model

data class Radio(
    val band: String?,
    val city: String?,
    val country: String?,
    val dial: String?,
    val genres: List<String>?,
    val id: Int,
    val language: String?,
    val listenerCount: Int = 0,
    val logo_big: String?,
    val logo_small: String?,
    val radioName: String?,
    val spotUrl: String?,
    val streams: List<Stream>?,
    val website: String?
)