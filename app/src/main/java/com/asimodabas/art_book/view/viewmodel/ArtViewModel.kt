package com.asimodabas.art_book.view.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asimodabas.art_book.view.model.ImageResponse
import com.asimodabas.art_book.view.repo.ArtRepositoryInterface
import com.asimodabas.art_book.view.roomdb.Art
import com.asimodabas.art_book.view.util.Resource
import kotlinx.coroutines.launch
import java.lang.Exception
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

    fun setSelectedImage(url : String){
        selectedImage.postValue(url)
    }

    fun deleteARt(art:Art) = viewModelScope.launch{
        repository.deleteArt(art)
    }

    fun insertArt(art: Art) = viewModelScope.launch{
        repository.insertArt(art)
    }

    fun makeArt(name:String,artistName:String,year:String){
        if (name.isEmpty() || artistName.isEmpty() || year.isEmpty()){
            insertArtMsg.postValue(Resource.error("Please fill in the blanks",null))
            return
        }
        val yearInt = try {
            year.toInt()
        }catch (e:Exception){
            insertArtMsg.postValue(Resource.error("Please enter the number",null))
            return
        }
        val art = Art(name,artistName,yearInt,selectedImage.value?:"")
        insertArt(art)
        setSelectedImage("")
        insertArtMsg.postValue(Resource.success(art))
    }

    fun searchImage(searchString: String){
        if (searchString.isEmpty()){
            return
        }
        images.value = Resource.loading(null)
        viewModelScope.launch {
            val response = repository.searchImage(searchString)
            images.value=response
        }
    }

}