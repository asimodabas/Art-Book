package com.asimodabas.art_book.roomdb

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import androidx.test.filters.SmallTest
import com.asimodabas.art_book.view.roomdb.ArtDao
import com.asimodabas.art_book.view.roomdb.ArtDatabase
import org.junit.Before
import org.junit.Rule

@SmallTest
@ExperimentalCoroutinesApi
class ArtDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao : ArtDao
    private lateinit var database : ArtDatabase

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),ArtDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.artDao()
    }


}