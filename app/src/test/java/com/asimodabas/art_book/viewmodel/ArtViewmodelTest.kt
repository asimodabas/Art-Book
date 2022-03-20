package com.asimodabas.art_book.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.asimodabas.art_book.MainCoroutineRule
import com.asimodabas.art_book.getOrAwaitValueTest
import com.asimodabas.art_book.repo.FakeArtRepository
import com.asimodabas.art_book.view.repo.ArtRepository
import com.asimodabas.art_book.view.util.Status
import com.asimodabas.art_book.view.viewmodel.ArtViewModel
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ArtViewmodelTest {

    @get:Rule
    var instantTaskExecutorRule=InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule=MainCoroutineRule()

    private lateinit var viewModel : ArtViewModel

    @Before
    fun setup(){
        viewModel = ArtViewModel(FakeArtRepository())
    }

    @Test
    fun `insert art without year return error`(){

        viewModel.makeArt("Mona Lisa","Da Vinci","")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)

    }

    @Test
    fun `insert art without name return error`(){


        viewModel.makeArt("","Da Vinci","1800")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)


    }

    @Test
    fun `insert art without artistName return error`(){


        viewModel.makeArt("Mona Lisa","","1800")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)


    }



}