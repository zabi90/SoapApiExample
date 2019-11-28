package com.example.soapapiexample

import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


object RetrofitAdapter {

    fun setupRetrofitWithTikXml(): Retrofit {

        val logging = HttpLoggingInterceptor()

        logging.level = HttpLoggingInterceptor.Level.BODY


        val client = OkHttpClient.Builder()
        client.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl("http://www.oorsprong.org/websamples.countryinfo/")
            .addConverterFactory(TikXmlConverterFactory.create())
            .client(client.build())
            .build()

    }

    @Suppress("DEPRECATION")
    fun setupRetrofitWithSimpleXml(): Retrofit {

        val logging = HttpLoggingInterceptor()

        logging.level = HttpLoggingInterceptor.Level.BODY


        val client = OkHttpClient.Builder()
        client.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl("http://www.oorsprong.org/websamples.countryinfo/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .client(client.build())
            .build()
    }
}