package bookandlearn.emailer

import org.grails.mandrill.*
import grails.gsp.PageRenderer

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(MailService)
class MailServiceSpec extends Specification {

    def setup() {
		service.mandrillService = GroovyMock(MandrillService)
        service.groovyPageRenderer = GroovyStub(PageRenderer)
    }

    def cleanup() {
    }

    void "Should send a mail after rendering a template"(){

    	when:
            service.groovyPageRenderer.render(_) >> '<html></html>'
            service.send(message, view, context)

        then:
            1 * service.mandrillService.send(_)

        where:
            message = GroovyStub(Email)
            view = 'irreal'
            context = [:]

    }

    void "Should send a mail to given recipients"(){
            
        when:
            service.send(message, recipients)

        then:
            1 * service.mandrillService.send(_)

        where:
            message = GroovyStub(Email)
            recipients = ['Juan Pérez': 'juan@perez.com']

    }


    void "Should compose an email"(){

        given:
    		service.groovyPageRenderer.render(_) >> render

        when:
            Email email = service.compose(subject, view, options)

            email.properties.each{println it}

        then:
            email.html == render
            email.subject == subject

        where:
            subject = 'welcome.mail'
            view = '/welcome/mail'
            render = '<html></html>'
            options = [:]

    }
}
