package com.example.codechallenge.data.source.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class APIClient(private val requestConfig: RequestConfig) {
    private val retrofit: Retrofit
    fun <T> createService(service: Class<T>?): T {
        return retrofit?.create(service)
    }

    /**
     * @return A configured [OkHttpClient] that will be used for executing network requests
     */
    private fun okHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        // Add custom interceptors from config
        for (interceptor in requestConfig?.interceptors) {
            builder?.addInterceptor(interceptor)
        }

        // Add timeouts
        builder.connectTimeout(requestConfig?.connectionTimeout.toLong(), TimeUnit.SECONDS)
            .readTimeout(requestConfig?.readTimeout.toLong(), TimeUnit.SECONDS)
            .writeTimeout(requestConfig?.writeTimeout.toLong(), TimeUnit.SECONDS)
        return builder.build()
    }

    /**
     * @param client The client that will be used for executing network requests
     * @return A configured [Retrofit] instance that can be used to create services interfaces
     */
    private fun retrofit(client: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
            .baseUrl(requestConfig?.baseUrl)
            .client(client)

        // Add custom converters (parsers)
        for (converterFactory in requestConfig?.converterFactories) {
            builder.addConverterFactory(converterFactory)
        }

        // Add custom call adapter factories
        for (callAdapterFactory in requestConfig?.callAdapterFactories) {
            builder.addCallAdapterFactory(callAdapterFactory)
        }
        return builder.build()
    }

    init {
        retrofit = retrofit(okHttpClient())
    }
}