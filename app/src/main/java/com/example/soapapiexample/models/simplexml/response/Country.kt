package com.example.soapapiexample.models.simplexml.response

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "tCountryCodeAndName")
class Country(
    @field:Element(name = "sISOCode")
    var isoCode: String? = null,
    @field:Element(name = "sName")
    var name: String? = null
)