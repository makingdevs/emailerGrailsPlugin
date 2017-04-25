package bookandlearn.emailer

class MandrillServiceMock{

    def filePath = 'web-app/media/email/latest-mail.html'

    /**
     * Save HTML isntead of sending mail
     */
	def send(Email email){
        def file = new File(filePath)
        file.text = email.html

        println '-----------------------------------------'
        println "Email saved in [${file.absolutePath}]"
        println '-----------------------------------------'

        return email
	}
	
}