package com.asimodabas.art_book.view.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asimodabas.art_book.view.model.ImageResponse
import com.asimodabas.art_book.view.repo.ArtRepositoryInterface
import com.asimodabas.art_book.view.roomdb.Art
import com.asimodabas.art_book.view.util.Resource
import javax.inject.Inject

class ArtViewModel @ViewModelInject constructor(
private val repository : ArtRepositoryInterface
) :ViewModel() {

    //For Art Fragment
    val artList = repository.getArt()

    //For ImageApi Fragment
    private val images = MutableLiveData<Resource<ImageResponse>>()
    val imageList : LiveData<Resource<ImageResponse>>
    get() = images

    private val selectedImage = MutableLiveData<String>()
    val selectedImageURL : LiveData<String>
    get() = selectedImage

    private var insertArtMsg = MutableLiveData<Resource<Art>>()
    val insertArtMessage : LiveData<Resource<Art>>
    get() = insertArtMsg

    fun resetInsertArtMessage (){
        insertArtMsg = MutableLiveData<Resource<Art>>()
    }

}