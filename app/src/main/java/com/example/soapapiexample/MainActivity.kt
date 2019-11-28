package com.example.soapapiexample

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soapapiexample.activities.simplexml.CountryListSimpleXmlActivity
import com.example.soapapiexample.activities.tikxml.CountryListActivity
import com.example.soapapiexample.extension.open
import com.example.soapapiexample.extension.toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        optionOne.setOnClickListener {
            open(CountryListActivity::class.java)
        }

        optionTwo.setOnClickListener {
            open(CountryListSimpleXmlActivity::class.java)
        }

        linkTextView.setOnClickListener {
            openWebPage(getString(R.string.link))
        }
    }

    fun openWebPage(url: String?) {
        try {
            val webpage: Uri = Uri.parse(url)
            val myIntent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(myIntent)
        } catch (e: ActivityNotFoundException) {
            toast("No application can handle this request. Please install a web browser or check your URL")
            e.printStackTrace()
        }
    }
}






