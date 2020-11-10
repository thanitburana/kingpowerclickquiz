package com.quiz.kingpowerclickquiz.view.customview

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.quiz.kingpowerclickquiz.R

class AlertDialog {
    companion object {
        fun show(
            context: Context,
            title: String? = null,
            massage: String,
            buttonOk: String? = null,
            buttonCancel: String? = null,
            onButtonListener: OnButtonListener
        ) {
            val mainView = AlertDialog.Builder(context).create()
            val layoutInflater = LayoutInflater.from(context).inflate(R.layout.alertdialog, null)
            val textViewTitle = layoutInflater.findViewById<TextView>(R.id.textView_title)
            val textViewCancel = layoutInflater.findViewById<TextView>(R.id.textView_cancel)
            val textViewConfirm = layoutInflater.findViewById<TextView>(R.id.textView_confrim)
            val textViewMassage = layoutInflater.findViewById<TextView>(R.id.textView_massage)
            mainView.setView(layoutInflater)
            textViewMassage.text = massage
            if (title == null) {
                textViewTitle.visibility = View.GONE
            } else {
                textViewTitle.text = title
            }

            if (buttonOk == null) {
                textViewConfirm.visibility = View.GONE
            } else {
                textViewConfirm.text = buttonOk
                textViewConfirm.setOnClickListener {
                    onButtonListener.onConfirm()
                    mainView.dismiss()
                }
            }

            if (buttonCancel == null) {
                textViewCancel.visibility = View.GONE
            } else {
                textViewCancel.text = buttonCancel
                textViewCancel.setOnClickListener {
                    onButtonListener.onCancel()
                    mainView.dismiss()
                }
            }
            mainView.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mainView.show()
        }
    }

    interface OnButtonListener {
        fun onConfirm()
        fun onCancel()
    }
}