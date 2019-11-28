package com.example.soapapiexample.models.simplexml


import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.NamespaceList
import org.simpleframework.xml.Root


@Root(name = "soap12:Envelope")
@NamespaceList(
    value = [Namespace(reference = "http://www.w3.org/2003/05/soap-envelope", prefix = "soap12")]
)
data class Envelope(
    @field:Element(name = "soap12:Body") var requestBody: RequestBody
)