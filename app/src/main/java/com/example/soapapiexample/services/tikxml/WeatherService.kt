package com.example.soapapiexample.services.tikxml

import com.example.soapapiexample.models.tikxml.Envelope
import com.example.soapapiexample.models.tikxml.response.ResponseEnvelope
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface WeatherService {

    @POST("CountryInfoService.wso")
    @Headers("Content-Type: application/soap+xml; charset=utf-8")
    fun getCityWeatherByZip(@Body envelope: Envelope): Call<ResponseEnvelope>
}

