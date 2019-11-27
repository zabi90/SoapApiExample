package com.example.soapapiexample.models.tikxml

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml


@Xml(name = "soap12:Body")
data class RequestBody(
    @Element(name = "ListOfCountryNamesByName") var listOfCountryNamesByName: ListOfCountryNamesByName
)


@Xml(name = "ListOfCountryNamesByName",writeNamespaces = ["=http://www.oorsprong.org/websamples.countryinfo"])
class ListOfCountryNamesByName