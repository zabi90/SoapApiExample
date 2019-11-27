package com.example.soapapiexample.activities.tikxml

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soapapiexample.R
import com.example.soapapiexample.RetrofitAdapter
import com.example.soapapiexample.adapters.tikxml.CountryListAdapter
import com.example.soapapiexample.extension.toast
import com.example.soapapiexample.models.tikxml.Envelope
import com.example.soapapiexample.models.tikxml.ListOfCountryNamesByName
import com.example.soapapiexample.models.tikxml.RequestBody
import com.example.soapapiexample.models.tikxml.response.ResponseEnvelope
import com.example.soapapiexample.services.tikxml.WeatherService
import kotlinx.android.synthetic.main.activity_country_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CountryListActivity : AppCompatActivity() {

    private val adapter = CountryListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_list)
        setupAdapter()
        setUpRetrofit()
    }

    private fun setupAdapter(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    private fun setUpRetrofit() {

        val retrofit = RetrofitAdapter.setupRetrofitWithTikXml()

        val service: WeatherService = retrofit.create(WeatherService::class.java)

        val requestBody = RequestBody(listOfCountryNamesByName = ListOfCountryNamesByName())

        val envelope =  Envelope(requestBody)

        val request = service.getCityWeatherByZip(envelope)

        progressBar.visibility = View.VISIBLE

        request.enqueue(object : Callback<ResponseEnvelope> {
            override fun onFailure(call: Call<ResponseEnvelope>, t: Throwable) {
                Log.d("MainActivity","response error ${t.message}")
                toast(t.message)
                progressBar.visibility = View.GONE
            }

            override fun onResponse(call: Call<ResponseEnvelope>, response: Response<ResponseEnvelope>) {
                progressBar.visibility = View.GONE
                if(response.isSuccessful){
                    val httpBody = response.body()
                    Log.d("MainActivity","response from $httpBody")
                    val countryList = httpBody?.body?.listOfCountryNamesByNameResponse?.countryList
                    adapter.setItems(countryList)
                }else{
                    Log.d("MainActivity","response not success : ${response.code()}")
                    toast("response not success httpCode:${response.code()}")
                }
            }
        })
    }

}
