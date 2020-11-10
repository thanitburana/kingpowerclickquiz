package com.quiz.kingpowerclickquiz.view

import android.content.Context
import android.content.Intent
import com.quiz.kingpowerclickquiz.api.model.response.Photo
import com.quiz.kingpowerclickquiz.view.activity.WebViwActivity

object ActivityNavigation {
    val TAG_PHOTO = "photo"
    fun gotoWebViewActivity(context: Context,photo: Photo){
        val intent = Intent(context,WebViwActivity::class.java)
        intent.putExtra(TAG_PHOTO,photo)
        context.startActivity(intent)
    }
}