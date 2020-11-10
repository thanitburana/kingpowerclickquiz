package com.quiz.kingpowerclickquiz.api.call

import com.quiz.kingpowerclickquiz.api.model.response.Photo
import retrofit2.Call
import retrofit2.http.GET

interface Photo {
    @GET("albums/1/photos")
    fun getPhoto() : Call<List<Photo>>
}