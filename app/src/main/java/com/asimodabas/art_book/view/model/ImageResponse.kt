package com.asimodabas.art_book.view.model

data class ImageResponse(
    val hits:List<ImageResult>,
    val total : Int,
    val totalHits : Int
)
