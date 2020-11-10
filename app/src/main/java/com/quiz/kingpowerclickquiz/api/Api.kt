package com.quiz.kingpowerclickquiz.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Api {
    companion object {
        fun <T> get(classCall: Class<T>, url: String? = null): T {
            return retrofit(
                classCall = classCall,
                url = url ?: "https://jsonplaceholder.typicode.com/"
            )
        }

        private fun <T> retrofit(classCall: Class<T>, url: String): T {
            val retrofit = Retrofit.Builder()
                .client(okHttpClient())
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(classCall)
        }

        private fun okHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()
        }
    }
}