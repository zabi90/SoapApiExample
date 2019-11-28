package com.example.soapapiexample.models.simplexml


import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.NamespaceList
import org.simpleframework.xml.Root


@Root(name = "soap12:Body")
data class RequestBody(
    @field:Element(name = "ListOfCountryNamesByName") var listOfCountryNamesByName: ListOfCountryNamesByName
)


@Root(name = "ListOfCountryNamesByName")
@NamespaceList(
    value = [Namespace(reference = "http://www.oorsprong.org/websamples.countryinfo")]
)
class ListOfCountryNamesByName