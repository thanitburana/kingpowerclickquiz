package com.quiz.kingpowerclickquiz.view.customview

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import com.quiz.kingpowerclickquiz.R

class Progress {
    companion object {
        fun loading(context: Context): AlertDialog {
            val mainView = AlertDialog.Builder(context).create()
            val layoutInflater = LayoutInflater.from(context).inflate(R.layout.progress, null)
            mainView.setView(layoutInflater)
            mainView.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mainView.window?.decorView?.systemUiVisibility =
                (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_FULLSCREEN)
            mainView.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
            return mainView
        }
    }
}