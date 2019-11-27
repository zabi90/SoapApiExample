package com.example.soapapiexample.models.tikxml.response

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Path
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "soap:Body")
data class ResponseBody(
    @Element(name = "m:ListOfCountryNamesByNameResponse")var listOfCountryNamesByNameResponse: ListOfCountryNamesByNameResponse)

@Xml(name = "m:ListOfCountryNamesByNameResponse",writeNamespaces = ["m=http://www.oorsprong.org/websamples.countryinfo"])
data class ListOfCountryNamesByNameResponse(
    @Path("m:ListOfCountryNamesByNameResult")
    @Element
    var countryList:List<Country>
)