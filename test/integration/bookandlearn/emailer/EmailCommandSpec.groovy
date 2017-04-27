package bookandlearn.emailer

import grails.test.mixin.TestFor
import spock.lang.*

class EmailCommandSpec extends Specification {

	void "verify validator command"() {
		given:
			def command = new EmailCommand()
			command.subject = "subject"
			command.model = [key1:1,key2:2]
			command.viewId = "viewId"
			command.fromName  = "fromName"
			command.emailTo = ["value1", "value2"]
			command.emailCC = true
			command.reporterEmail = "reporterEmail"
			command.nameRecipient = "nameRecipient"
		when:
			command.validate()
		then:
			command.hasErrors() == false
	}

	void "verify validator command"() {
		given:
			def command = new EmailCommand()
			command.subject = "subject"
			command.model = [:]
			command.viewId = "viewId"
			command.fromName  = "fromName"
			command.emailTo = ["value1", "value2"]
			command.emailCC = true
			command.reporterEmail = "reporterEmail"
			command.nameRecipient = "nameRecipient"
		when:
			command.validate()
		then:
			command.hasErrors() == true
	}
}