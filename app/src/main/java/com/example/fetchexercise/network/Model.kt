package com.example.fetchexercise.network

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NetworkHiring(
    val id: Int,
    val listId: Int,
    val name: String?,
)