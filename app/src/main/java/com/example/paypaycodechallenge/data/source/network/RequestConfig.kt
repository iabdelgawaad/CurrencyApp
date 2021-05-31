package com.example.paypaycodechallenge.data.source.network

import android.text.TextUtils
import com.example.paypaycodechallenge.BuildConfig
import okhttp3.Interceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import java.util.*

class RequestConfig constructor(
    baseUrl: String? = BuildConfig.BASE_URL,
    connectionTimeout: Int = CONNECTION_TIMEOUT,
    readTimeout: Int = READ_TIMEOUT,
    writeTimeout: Int = WRITE_TIMEOUT
) {
    var baseUrl: String?
    var connectionTimeout = TIMEOUT_DEFAULT_VALUE
    var readTimeout = TIMEOUT_DEFAULT_VALUE
    var writeTimeout = TIMEOUT_DEFAULT_VALUE

    //region Getters
    val headers: Map<String, String>? = null
    val params: Map<String, String>? = null
    val interceptors: MutableList<Interceptor> = ArrayList()
    val converterFactories: MutableList<Converter.Factory> = ArrayList()
    val callAdapterFactories: MutableList<CallAdapter.Factory> = ArrayList()

    //endregion
    private fun verify(
        baseUrl: String?,
        connectionTimeout: Int,
        readTimeout: Int,
        writeTimeout: Int
    ) {
        if (TextUtils.isEmpty(baseUrl)) throwInvalidParameter("Base URL cannot be null or empty!")
        if (connectionTimeout < 0) throwInvalidParameter("Connection timeout cannot be less than zero!")
        if (readTimeout < 0) throwInvalidParameter("Read timeout cannot be less than zero!")
        if (writeTimeout < 0) throwInvalidParameter("Write timeout cannot be less than zero!")
    }

    private fun throwInvalidParameter(msg: String) {
        throw IllegalArgumentException(msg)
    }

    //region Adding custom values to network executor
    fun addInterceptor(interceptor: Interceptor) {
        interceptors.add(interceptor)
    }

    fun addConverterFactory(factory: Converter.Factory) {
        converterFactories.add(factory)
    }

    fun addCallAdapterFactory(factory: CallAdapter.Factory) {
        callAdapterFactories.add(factory)
    }

    fun getCallAdapterFactories(): List<CallAdapter.Factory> {
        return callAdapterFactories
    }

    fun getConverterFactories(): List<Converter.Factory> {
        return converterFactories
    }

    fun getInterceptors(): List<Interceptor> {
        return interceptors
    }

    companion object {
        private const val TIMEOUT_DEFAULT_VALUE = 20

        /* Timeout values in seconds */
        const val CONNECTION_TIMEOUT = 60
        const val READ_TIMEOUT = 60
        const val WRITE_TIMEOUT = 60
    }

    init {
        verify(baseUrl, connectionTimeout, readTimeout, writeTimeout)
        this?.baseUrl = baseUrl
        this?.connectionTimeout = connectionTimeout
        this?.readTimeout = readTimeout
        this?.writeTimeout = writeTimeout
    }
}