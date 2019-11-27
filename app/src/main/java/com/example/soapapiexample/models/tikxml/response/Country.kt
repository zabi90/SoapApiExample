package com.example.soapapiexample.models.tikxml.response

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "m:tCountryCodeAndName")
data class Country(
    @PropertyElement(name = "m:sISOCode")
    var isoCode:String,
    @PropertyElement(name = "m:sName")
    var name:String
)