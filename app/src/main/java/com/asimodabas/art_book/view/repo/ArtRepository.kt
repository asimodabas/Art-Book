package com.asimodabas.art_book.view.repo

import androidx.lifecycle.LiveData
import com.asimodabas.art_book.view.api.RetrofitAPI
import com.asimodabas.art_book.view.model.ImageResponse
import com.asimodabas.art_book.view.roomdb.Art
import com.asimodabas.art_book.view.roomdb.ArtDao
import com.asimodabas.art_book.view.util.Resource
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class ArtRepository @Inject constructor (
    private val artDao : ArtDao,
    private val retrofitApi : RetrofitAPI
) : ArtRepositoryInterface {

    override suspend fun insertArt(art: Art) {
        artDao.insertArt(art)
    }

    override suspend fun deleteArt(art: Art) {
        artDao.deleteArt(art)
    }

    override fun getArt(): LiveData<List<Art>> {
        return artDao.observeArts()
    }

    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return try {
            val response = retrofitApi.imageSearch(imageString)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error",null)
            } else {
                Resource.error("Error",null)
            }
        } catch (e: Exception) {
            Resource.error("No data!",null)
        }
    }


}