package com.asimodabas.art_book.view.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Art::class], version = 1)
abstract class ArtDatabase :RoomDatabase(){
    abstract fun artDao() :ArtDao
}