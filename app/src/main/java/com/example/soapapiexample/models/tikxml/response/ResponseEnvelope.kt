package com.example.soapapiexample.models.tikxml.response

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

@Xml(
    name = "soap:Envelope", writeNamespaces = [
        "soap=http://www.w3.org/2003/05/soap-envelope"
    ]
)
data class ResponseEnvelope(
    @Element(name = "soap:Body") var body: ResponseBody
)