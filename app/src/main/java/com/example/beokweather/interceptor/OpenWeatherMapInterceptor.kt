package com.example.beokweather.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OpenWeatherMapInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url()
            .newBuilder()
            .addQueryParameter(
                "appid",
                API_KEY
            )
            .build()

        val request = chain.request().newBuilder().url(url).build()
        return chain.proceed(request)
    }

    companion object {
        private const val API_KEY = "2e6c1e481f600b6cb9166a0d297da31a"
    }
}