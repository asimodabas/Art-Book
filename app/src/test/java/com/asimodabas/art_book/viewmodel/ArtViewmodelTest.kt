package com.asimodabas.art_book.viewmodel

import com.asimodabas.art_book.repo.FakeArtRepository
import com.asimodabas.art_book.view.repo.ArtRepository
import com.asimodabas.art_book.view.viewmodel.ArtViewModel
import org.junit.Before
import org.junit.Test

class ArtViewmodelTest {

    private lateinit var viewModel : ArtViewModel

    @Before
    fun setup(){
        viewModel = ArtViewModel(FakeArtRepository())
    }

    @Test
    fun `insert art without year return error`(){

        viewModel.makeArt("Mona Lisa","Da Vinci","")
        val value = viewModel.insertArtMessage

    }

    @Test
    fun `insert art without name return error`(){



    }

    @Test
    fun `insert art without artistName return error`(){



    }



}