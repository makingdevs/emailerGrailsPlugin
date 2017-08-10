package com.sophossystems.idiomasXelMundo.mail

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(SendJsonEmailerService)
@Mock(SendJsonEmailerService)
class SendJsonEmailerServiceSpec extends Specification {

    def builder = new groovy.json.JsonBuilder()

    void "send json to emailer for method post"() {
      given:"create a json as email"
      Emailer email = new Emailer(idE:"5989ecd95c95c4513f84d724",
                                  toE:"leovergara.dark@gmail.com",
                                  ccE: "brandon@makingdevs.com",
                                  ccoE: "emailer2@app.com",
                                  subjectE: "realizando test",
                                  mensajeE: "Hola a todos",
                                  despedidaE: "Adios",
                                  firmaE: "Making Devs, 2017"
                                 )
      when:"send email to amiler"
        def result = service.sendJsonEmailer(email)
      then:
        result.statusCode == 201


    }
}
