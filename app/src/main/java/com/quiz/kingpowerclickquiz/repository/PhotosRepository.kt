package com.quiz.kingpowerclickquiz.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.quiz.kingpowerclickquiz.R
import com.quiz.kingpowerclickquiz.api.Api
import com.quiz.kingpowerclickquiz.api.CallBackApi
import com.quiz.kingpowerclickquiz.api.call.Photo
import com.quiz.kingpowerclickquiz.view.customview.AlertDialog

class PhotosRepository {
    companion object {
        private var INSTANT: PhotosRepository? = null
        fun getInstant() = INSTANT ?: PhotosRepository().also {
            INSTANT = it
        }
    }

    fun getPhotos(context: Context): MutableLiveData<List<com.quiz.kingpowerclickquiz.api.model.response.Photo>> {
        val data = MutableLiveData<List<com.quiz.kingpowerclickquiz.api.model.response.Photo>>()
        CallBackApi.cal(
            call = Api.get(Photo::class.java).getPhoto(),
            context = context,
            onCallBackApi = object :
                CallBackApi.OnCallBackApi<List<com.quiz.kingpowerclickquiz.api.model.response.Photo>> {
                override fun onError(error: String?, t: Throwable?) {
                    if (error!= null){
                        AlertDialog.show(context = context,
                            massage = error,
                            buttonOk = context.resources.getString(
                                R.string.ok
                            ),
                            onButtonListener = object : AlertDialog.OnButtonListener {
                                override fun onConfirm() {}

                                override fun onCancel() {}
                            })
                    }else{
                        AlertDialog.show(context = context,
                            massage =context.resources.getString(R.string.button_text_reply),
                            buttonOk = context.resources.getString(
                                R.string.ok
                            ),
                            onButtonListener = object : AlertDialog.OnButtonListener {
                                override fun onConfirm() {
                                    getPhotos(context = context)
                                }

                                override fun onCancel() {}
                            })
                    }

                }

                override fun onNetworkError(massage: String) {
                    AlertDialog.show(context = context,
                        massage = massage,
                        buttonOk = context.resources.getString(
                            R.string.ok
                        ),
                        onButtonListener = object : AlertDialog.OnButtonListener {
                            override fun onConfirm() {
                                getPhotos(context=context)
                            }

                            override fun onCancel() {}
                        })
                }

                override fun onResponse(response: List<com.quiz.kingpowerclickquiz.api.model.response.Photo>) {
                    data.value = response
                }
            })
        return data
    }
}