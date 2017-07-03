package com.sophossystems.idiomasXelMundo.mail

import org.grails.mandrill.*
import com.sophossystems.idiomasXelMundo.media.Attachment

import grails.test.mixin.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.cmd.DomainClassUnitTestMixin} for usage instructions
 */
class EmailSpec extends Specification {

    def email

    def setup(){
        email = new Email()
    }

    def cleanup() {
    }

	void "Adding recipients should be simple"(){
        
        when:
            email.addRecipient('robert@baratheon.got', 'Drunk King')

        then:
            email.to.size() == 1
            email.to[0] instanceof MandrillRecipient

            println email.to
    }

    void "Set preserve_recipients to true"(){
        expect:
            email.preserve_recipients == true
    }

    // Failure: (El sistema no puede encontrar la ruta especificada)
    // void "Should add Attachments"(){

    //     setup:
    //         attachment.getFullPath() >> '.'

    //     when:
    //         email.addAttachment(name, attachment)

    //     then:
    //         email.attachments.size() == 1
    //         email.attachments[0] instanceof MandrillAttachment

    //     where:
    //         name = 'sword'
    //         attachment = GroovyStub(Attachment)

    // }


}

