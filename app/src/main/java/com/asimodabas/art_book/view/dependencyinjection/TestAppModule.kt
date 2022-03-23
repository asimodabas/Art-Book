package com.asimodabas.art_book.view.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.asimodabas.art_book.view.roomdb.ArtDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    fun injectInMemoryRoom(@ApplicationContext context:Context){

        Room.inMemoryDatabaseBuilder(context,ArtDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

}