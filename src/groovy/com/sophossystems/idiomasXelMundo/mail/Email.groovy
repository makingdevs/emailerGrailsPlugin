package com.sophossystems.idiomasXelMundo.mail

import org.grails.mandrill.MandrillMessage
import org.grails.mandrill.MandrillRecipient
import org.grails.mandrill.MandrillAttachment

import com.sophossystems.idiomasXelMundo.media.Attachment

/**
 *
 * Wrapper of MandrillEmail class, with utility method sicnluded
 */
class Email extends MandrillMessage{

	Email(){
		to = []
		attachments = []

		// Since CC is not natively supported, setting this options to
		// true adds the recipient to the list
		preserve_recipients = true
	}

	void setRecipient(String email, String name){
		to = [new MandrillRecipient(name:name, email:email)]
	}

	// @TODO Allow adding type property in recipients 
	// https://www.mandrillapp.com/api/docs/messages.JSON.html#method=send
	void addRecipient(String email, String name){
		to.add(new MandrillRecipient(name: name, email:email))
	}

	/**
	 * Alias to add a new attachement using Attachment class as parameter
	 * 
	 * @param name       Name of the attachment
	 * @param attachment Attachment taht wil be read to get bytes
	 */
	void addAttachment(String name, Attachment attachment){
		addAttachment(name, new File(attachment.getFullPath())?.readBytes(), attachment.mime)
	}

	/**
	 * Add attachment to email
	 * @param name    Name of the file to be attached
	 * @param content Bytes of the file
	 */
	void addAttachment(String name, byte[] content, String mime){
		attachments.add(new MandrillAttachment(
			type: mime, 
			name: name, 
			// must be base64 encoded to be properly added
			content: content.encodeBase64().toString()
		))
	}
}
