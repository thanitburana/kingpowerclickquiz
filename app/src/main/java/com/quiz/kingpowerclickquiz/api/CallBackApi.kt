package com.quiz.kingpowerclickquiz.api

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.quiz.kingpowerclickquiz.BaseApplication
import com.quiz.kingpowerclickquiz.R
import com.quiz.kingpowerclickquiz.utils.EnumNetWorkConnection
import com.quiz.kingpowerclickquiz.utils.NetworkUtil
import com.quiz.kingpowerclickquiz.view.customview.Progress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallBackApi {
    companion object{
        private var progress :AlertDialog?=null
        fun <T> cal(call : Call<T>, onCallBackApi: OnCallBackApi<T>,context: Context?=null){
            progress =  checkProgress(context = context)
            if (progress!= null)
                progress!!.show()
            if (NetworkUtil.getConnection() != EnumNetWorkConnection.NOT_CONNECTION){
                call.enqueue(object  : Callback<T>{
                    override fun onResponse(call: Call<T>, response: Response<T>) {
                        if (progress!= null)
                            progress!!.dismiss()
                        if (response.isSuccessful){
                            onCallBackApi.onResponse(response = response.body()!!)
                        }else{
                            onCallBackApi.onError(response.errorBody()!!.string(),null)
                        }
                    }

                    override fun onFailure(call: Call<T>, t: Throwable) {
                        if (progress!= null)
                            progress!!.dismiss()
                        onCallBackApi.onError(null, t)
                    }
                })
            }else{
                if (progress!= null)
                    progress!!.dismiss()
                onCallBackApi.onNetworkError(BaseApplication.getContext().resources.getString(R.string.not_connect_network))
            }
        }

        private fun checkProgress(context: Context?=null): AlertDialog? {
            if (context != null){
                return Progress.loading(context = context)
            }
            return null
        }
    }


    interface OnCallBackApi<T>{
        fun onError(error: String? = null, t: Throwable? = null)
        fun onNetworkError(massage : String)
        fun onResponse(response: T)
    }
}