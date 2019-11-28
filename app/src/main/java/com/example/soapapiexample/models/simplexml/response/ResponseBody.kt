package com.example.soapapiexample.models.simplexml.response

import org.simpleframework.xml.*


@Root(name = "Body")
data class ResponseBody(
    @field:Element(name = "ListOfCountryNamesByNameResponse") var listOfCountryNamesByNameResponse: ListOfCountryNamesByNameResponse? = null
)

@Root(name = "ListOfCountryNamesByNameResponse")
@NamespaceList(
    value = [Namespace(reference = "http://www.oorsprong.org/websamples.countryinfo", prefix = "m")]
)
data class ListOfCountryNamesByNameResponse(
    @field:ElementList(name = "ListOfCountryNamesByNameResult", entry = "tCountryCodeAndName")
    var countryList: List<Country>? = null
)
