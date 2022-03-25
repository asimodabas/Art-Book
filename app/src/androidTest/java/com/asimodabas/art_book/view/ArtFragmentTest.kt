package com.asimodabas.art_book.view

import androidx.test.filters.MediumTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@MediumTest
@HiltAndroidTest
class ArtFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup (){
        hiltRule.inject()
    }

    @Test
    fun testNavigationFromArtToArtDetails(){
        
    }


}