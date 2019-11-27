package com.example.soapapiexample.models.tikxml

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

@Xml(
    name = "soap12:Envelope", writeNamespaces = [
        "soap12=http://www.w3.org/2003/05/soap-envelope"
    ]
)
data class Envelope(
    @Element(name = "soap12:Body") var requestBody: RequestBody
)