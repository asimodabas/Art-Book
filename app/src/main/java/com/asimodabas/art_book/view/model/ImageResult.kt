package com.asimodabas.art_book.view.model

import com.google.gson.annotations.SerializedName

data class ImageResult(
    @SerializedName("user_id")
    val userId: Int,
    val comments: Int,
    val id: Int,
    val previewWidth: Int,
    val tags: String,
    val views: Int, val imageSize: Int,
    val downloads: Int,
    val favorites: Int,
    val user: String,
    val webformatWidth: Int,
    val imageWidth: Int,
    val largeImageURL: String,
    val likes: Int,
    val pageURL: String,
    val webformatHeight: Int,
    val webformatURL: String,
    val imageHeight: Int,
    val type: String,
    val userImageURL: String,
    val previewHeight: Int,
    val previewURL: String,
)
