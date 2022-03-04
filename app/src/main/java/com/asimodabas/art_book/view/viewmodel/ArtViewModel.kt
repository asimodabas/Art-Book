package com.asimodabas.art_book.view.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.asimodabas.art_book.view.repo.ArtRepositoryInterface
import javax.inject.Inject

class ArtViewModel @ViewModelInject constructor(
private val repository : ArtRepositoryInterface
) :ViewModel() {
    val artList = repository.getArt()


}