package com.sophossystems.idiomasXelMundo.mail

import grails.transaction.Transactional
import wslite.rest.*
import groovy.json.JsonBuilder

@Transactional(readOnly = true)
class TemplateMailerService {

    def sendEmail(Map destData, String templateId, Map domainParams) {
      print "sending Email...."
      def templateMail = new TamplateEmail(
        destData: destData, templateId: templateId, domainParams: domainParams)
      def client = new RESTClient("http://localhost:8000/")
      println templateMail.getJsonEmailser().toPrettyString()
      def response = client.post(path:"serviceEmail"){
        type ContentType.JSON
        text templateMail.getJsonEmailser().toPrettyString()
      }
   }
}
