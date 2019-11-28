package com.example.soapapiexample.services.simplexml


import com.example.soapapiexample.models.simplexml.Envelope
import com.example.soapapiexample.models.simplexml.response.ResponseEnvelope
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface WeatherService {

    @POST("CountryInfoService.wso")
    @Headers("Content-Type: application/soap+xml; charset=utf-8")
    fun getCityWeatherByZip(@Body envelope: Envelope): Call<ResponseEnvelope>
}

