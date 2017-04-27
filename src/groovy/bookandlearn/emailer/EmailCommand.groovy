package bookandlearn.emailer

@grails.validation.Validateable
class EmailCommand {

	String subject

	Map model

	String viewId

	String fromName

	List<String> emailTo

	Boolean emailCC

	String reporterEmail

	String nameRecipient

	Attachment attachment



	static constraints = {
		subject nullable: false
		model nullable:false,  validator:  { Map map, obj, errors ->
       		if (map.size() < 1) errors.rejectValue('model', 'minSize.notmet')
    	}
    	viewId nullable: false
    	fromName nullable: false
    	emailTo nullable:false
    	emailCC nullable: true
    	reporterEmail nullable: true
    	nameRecipient nullable: true
	}


}