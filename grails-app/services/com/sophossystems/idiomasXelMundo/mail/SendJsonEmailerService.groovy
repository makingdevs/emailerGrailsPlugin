package com.sophossystems.idiomasXelMundo.mail

import grails.transaction.Transactional
import wslite.rest.*
import groovy.json.JsonBuilder

@Transactional
class SendJsonEmailerService {

    def sendJsonEmailer(Emailer email) {
      def client = new RESTClient("http://localhost:8000/")
      client.defaultCharset = "UTF-8"
      def response = client.post(path:"serviceEmail"){
        type ContentType.JSON
        text email.getJsonEmailser().toPrettyString()
      }
    }
}
