package com.example.soapapiexample.models.simplexml.response


import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.NamespaceList
import org.simpleframework.xml.Root

@Root(name = "soap:Envelope")
@NamespaceList(
    value = [Namespace(reference = "http://www.w3.org/2003/05/soap-envelope", prefix = "soap")]
)
data class ResponseEnvelope(
    @field:Element(name = "Body") var body: ResponseBody? = null
)