package com.asimodabas.art_book.view.repo

import androidx.lifecycle.LiveData
import com.asimodabas.art_book.view.model.ImageResponse
import com.asimodabas.art_book.view.roomdb.Art
import com.asimodabas.art_book.view.util.Resource

interface ArtRepositoryInterface {

    suspend fun insertArt(art: Art)

    suspend fun deleteArt(art: Art)

    fun getArt() : LiveData<List<Art>>

    suspend fun searchImage(imageString:String) : Resource<ImageResponse>
}