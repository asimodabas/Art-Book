package com.asimodabas.art_book.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.asimodabas.art_book.R
import com.asimodabas.art_book.getOrAwaitValue
import com.asimodabas.art_book.launchFragmentInHiltContainer
import com.asimodabas.art_book.repo.FakeArtRepositoryTest
import com.asimodabas.art_book.view.adapter.ImageRecyclerAdapter
import com.asimodabas.art_book.view.view.ArtFragmentFactory
import com.asimodabas.art_book.view.view.ImageAPIFragment
import com.asimodabas.art_book.view.viewmodel.ArtViewModel
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import javax.inject.Inject

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class ImageApiFragmentTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var fragmentFactory: ArtFragmentFactory

    @Before
    fun setup (){
        hiltRule.inject()
    }

    @Test
    fun selectImage(){

        val navController = Mockito.mock(NavController::class.java)
        val selectedImageUrl = "asimodabas.com"
        val testViewModel = ArtViewModel(FakeArtRepositoryTest())

        launchFragmentInHiltContainer<ImageAPIFragment>(
            factory = fragmentFactory
        ){
            Navigation.setViewNavController(requireView(),navController)
            viewModel =testViewModel
            imageRecyclerAdapter.images = listOf(selectedImageUrl)
        }

        Espresso.onView(withId(R.id.imageRecyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ImageRecyclerAdapter.ImageViewHolder>(
                0,click()
            )
        )
        Mockito.verify(navController).popBackStack()
        assertThat(testViewModel.selectedImageURL.getOrAwaitValue()).isEqualTo(selectedImageUrl)
    }

}