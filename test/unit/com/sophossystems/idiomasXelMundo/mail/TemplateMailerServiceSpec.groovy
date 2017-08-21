package com.sophossystems.idiomasXelMundo.mail

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(TemplateMailerService)
class TemplateMailerServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test send email to destination data with  template id and domain pars"() {
      given: "destination data"
        def Map destData = [to:["hoshdog@gmail.com"],
                        cc:["antonio@makingdevs.com"],
                        cco:["hoshdog@gmail.com"],
                        subject:"big test" ]
      and: "template id"
        def templateId = "5995cf990bb6235340152acf"
      and: "domain params"
        def Map domainParams = [mensaje:"Adios", firma: "Making dev, 2017"]
      when: "send email "
        def result = service.sendEmail(destData, templateId, domainParams)
      then: "result should be ok"
        println result.statusCode
        result.statusCode == 201
    }
}
