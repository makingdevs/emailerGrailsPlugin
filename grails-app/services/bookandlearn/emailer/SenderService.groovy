package bookandlearn.emailer


class SenderService {

	def mailService

	def sendEmailTo(EmailCommand command) {

		Email email = new Email(
            from_email: "correo@correo.com",//mailerService.defaultSender,
            from_name: command.fromName,
            subject: command.subject
        )

        command.emailTo.each { address ->
      		email.addRecipient(address, command.nameRecipient ?: "")
    	}

    	if(command.attachment){
            email.addAttachment(quote.course.name, quote.course.brochure)
        }

        if (command.emailCC)
      		email.headers = ["Reply-To":command.reporterEmail]

    	email.html = mailService.view("/templates/${command.viewId}", command.model)
    	mailService.send(email)
    	email
	}

}
