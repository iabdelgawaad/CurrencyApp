package com.example.paypaycodechallenge.data.source.network

import com.example.paypaycodechallenge.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RequestManager private constructor() {
    private var baseURL: String? = null
    private fun generateRequestConfig(): RequestConfig {
        var commonConfig = RequestConfig()

        // Allowing children classes to update the config object, couple of things are to be noted here
        // 1- This is done before adding the headers interceptor so that it includes all headers (common and child's)
        // 2- Any Converters added by children will be added first and has priority over the default converter
        // 3- Any CallAdapters added by children will be added first and has priority over default call adapter
        commonConfig = updateRequestConfig(commonConfig)


        // Adding request/response logger in debug builds
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            commonConfig.addInterceptor(loggingInterceptor)
        }

        // Adding default converters and call adapters
        commonConfig.addConverterFactory(GsonConverterFactory.create(commonGsonInstance))
        commonConfig.addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        commonConfig.baseUrl = if (baseURL == null) BuildConfig.BASE_URL else baseURL
        return commonConfig
    }

    private val commonGsonInstance: Gson
        private get() = GsonBuilder().create()

    /**
     * Helper method for creating a Retrofit service interface implementation
     *
     * @param clazz Retrofit service interface class object
     * @param <T>   Retrofit service interface type
     * @return An implementation of Retrofit service interface
    </T> */
    fun <T> startRequest(clazz: Class<T>?): T {
        return APIClient(generateRequestConfig()).createService(clazz)
    }

    fun <T> startRequest(clazz: Class<T>?, requestConfig: RequestConfig?): T {
        return APIClient(requestConfig!!).createService(clazz)
    }

    private fun updateRequestConfig(requestConfig: RequestConfig): RequestConfig {
        return requestConfig
    }

    companion object {
        private var mRequestManager: RequestManager? = null

        @get:Synchronized
        val instance: RequestManager?
            get() {
                if (mRequestManager == null) {
                    mRequestManager = RequestManager()
                }
                return mRequestManager
            }
    }
}