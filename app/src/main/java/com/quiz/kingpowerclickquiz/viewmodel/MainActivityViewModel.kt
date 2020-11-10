package com.quiz.kingpowerclickquiz.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quiz.kingpowerclickquiz.api.model.response.Photo
import com.quiz.kingpowerclickquiz.repository.PhotosRepository

class MainActivityViewModel : ViewModel() {
    private val photosRepository = PhotosRepository.getInstant()

    fun getPhotos(context: Context): MutableLiveData<List<Photo>> {
        return photosRepository.getPhotos(context)
    }
}