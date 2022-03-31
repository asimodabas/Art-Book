package com.asimodabas.art_book.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.MediumTest
import com.asimodabas.art_book.view.view.ArtFragmentFactory
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import javax.inject.Inject

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class ArtDetailsFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTextExecutorRule =InstantTaskExecutorRule()

    @Inject
    lateinit var fragmentFactory :ArtFragmentFactory

    @Before
    fun setup(){
        hiltRule.inject()
    }




}