package com.quiz.kingpowerclickquiz.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.quiz.kingpowerclickquiz.BaseApplication

class NetworkUtil {
    companion object {
        fun getConnection(): EnumNetWorkConnection {
            var result = EnumNetWorkConnection.NOT_CONNECTION
            val connectivityManager = BaseApplication.getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val networkCapabilities =
                    connectivityManager.activeNetwork ?: return EnumNetWorkConnection.NOT_CONNECTION
                val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities)
                    ?: return EnumNetWorkConnection.NOT_CONNECTION
                result = when {
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> EnumNetWorkConnection.WIFI
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> EnumNetWorkConnection.MOBILE
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> EnumNetWorkConnection.ETHERNET
                    else -> EnumNetWorkConnection.NOT_CONNECTION
                }
            } else {
                connectivityManager.run {
                    connectivityManager.activeNetworkInfo?.run {
                        result = when (type) {
                            ConnectivityManager.TYPE_WIFI -> EnumNetWorkConnection.WIFI
                            ConnectivityManager.TYPE_MOBILE -> EnumNetWorkConnection.MOBILE
                            ConnectivityManager.TYPE_ETHERNET -> EnumNetWorkConnection.ETHERNET
                            else -> EnumNetWorkConnection.NOT_CONNECTION
                        }

                    }
                }
            }
            return result
        }
    }
}