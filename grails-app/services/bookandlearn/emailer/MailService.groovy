package bookandlearn.emailer

import grails.gsp.PageRenderer

/**
 * MailerService
 * A service class encapsulates the core business logic of a Grails application
 */
class MailService {

	static transactional = false

	def mandrillService
    String defaultAddress

    /**
     * Default address emails will be sent
     */
    String defaultSender

	PageRenderer groovyPageRenderer

    /**
     * Method to send mail using template and model
     * 
     * @param subject mail subject
     * @param  view Path to mail view
     * @param  options Map to override default options
     * @arg  String locale ISO code of mail language
     * @return Email
     */
    Email compose(String subject, String view, Map<String, Object> model){
        new Email(
            //@TODO Support multiple users
            from_email: defaultSender,
            from_name: model.from_name ?: '(no reply)',

            //@TODO AcceptArguments
            subject: subject,
            html: loadView(view, model)
        )
    }


	// Wrapper to mandrillService.mail with template rendering
    def send(Email mail, String template, Map model){
        addHtml(mail, template, model)
    	send(mail)
    }


    /**
     * Alias to senda mail. Second params allows to define
     * recipients
     * @param  mail       
     * @param  recipients 
     * @return            
     */
    def send(Email email, Map<String, String> recipients){
        recipients.each{ 
            email.addRecipient(it.key, it.value) 
        }

        send(email)
    }

    /**
     * Send mail using mandirllService
     * @param  mail Email to be sent
     * @return      
     */
    def send(Email mail){
        if(defaultAddress){
            log.debug "Using default address instead of ${mail.to.email} given"

            mail.setRecipient(defaultAddress, 'Master Key Default Mail')
        }

        log.info("Sending mail from [${mail.from_email}] to [${mail.to.email}]: [${mail.subject}]")

        mandrillService.send(mail)
    }


    void addHtml(Email mail, String view, Map model){
        def content = groovyPageRenderer.render(template: view, model: model)
        mail.setHtml(content)
    }


    /**
     * Load a view 
     * @deprecated  now it's an laias of loadView, in the future in may be removed
     */
    String view(String view, Map model){
        loadView(view, model)
    }

    /**
     * LoadView using groovyPage renderer
     * 
     * @param  view  Tempalte to parse
     * @param  model Model used to parse
     * @return       
     */
    String loadView(String view, Map model){
        groovyPageRenderer.render(view: view, model: model)
    }
}
