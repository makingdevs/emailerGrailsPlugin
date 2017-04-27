package bookandlearn.emailer

import spock.lang.*


class SenderServiceSpec extends Specification {

	def senderService
	def localService

	void "send comparative email"() {
		given:
			Map model = [
				message: "comment",
				lang: localService.getCurrentLang(),
				link: "link",
				distributor: [:],
				reporter: [:],
				tenant: [:],
				tokenExpiry: new Date()
			]
		and:
			EmailCommand command = new EmailCommand()
			command.subject = "subject"
			command.viewId = "comparative"
			command.fromName = "info@bookandlearn.com"
			command.emailTo = ["email@correo.com"]
			command.emailCC = false
			command.reporterEmail = "reporter@correo.com"
		when:
			def result = senderService.sendEmailTo(command)
		then:
			result != null
			println result.subject

	}
}