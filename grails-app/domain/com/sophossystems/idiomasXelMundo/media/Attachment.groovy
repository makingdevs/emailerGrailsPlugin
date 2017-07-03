package com.sophossystems.idiomasXelMundo.media

import org.springframework.web.multipart.MultipartFile
import com.sophossystems.idiomasXelMundo.utils.Reference

/**
 * Attachment
 * A domain class describes the data object and it's mapping to the database
 */
class Attachment {
	
	def storagePathService

	/**
	 * Path is the external identifier because it's also unique and
	 * is more useful to the resource. With the path the resource
	 * can build the full URL, and even change server
	 */
	String path
	String name
	
	String mime
	Long size

	AttachmentType type
	
	// Reference
	// Domain should not be Clas because of https://jira.grails.org/browse/GRAILS-6020
	// @TODO Add to Custom Hibvernate UserType
	String referenceDomain
	Long referenceId

	Date dateCreated

	def file

	static constraints = {
		path nullable: false, bindable: false, unique: true
		name nullable: true, bindable: false

		mime nullable: false, bindable: false
		size nullable: false, bindable: false

		type nullable: false
		
		referenceId nullable: false, bindable: false
		referenceDomain nullable: false, bindable: false
	}

	/**
	 * Helper method to constraint to a given type
	 * 
	 * @param  type [description]
	 * @return  Closure    [description]
	 */
	static Closure constraintTo(type){{ Attachment file ->
		if(!file?.type) return

		AttachmentType attachmentType = type

		(file.type != attachmentType) ?  ['attachmentType.invalid'] : null
	}}

	static transients = ['reference', 'file', 'extension', 'fullPath']


	/**
	 * All file related properties should be bounded using File
	 * @param file [description]
	 */
	void setFile(MultipartFile file){
		this.file = file
		this.mime = file.contentType
        this.size = file.getSize()
		this.name = file.originalFilename
	}

	Reference getReference(){
		if(referenceDomain)
			new Reference(referenceDomain, referenceId)
	}

	void setReference(Reference reference){
		referenceId = reference?.ident
		referenceDomain = reference?.domain?.name
	}

	String getExtension(){
        if(!name || ! name?.contains('.')){ return }
        return '.' + name.split(/\./)?.last()
    }

    String getUrl(){
    	storagePathService.getUrl(path)
    }

    String getFullPath(){
    	// attachmentService?.basePath + path
    }

    static namedQueries = {
    	byReference {Class domain, Long id ->
    		eq 'referenceDomain', domain?.name
    		eq 'referenceId', id
    	}

    	byReferenceAndType {Class domain, Long id, AttachmentType type ->
    		byReference domain, id
    		eq 'type', type
    	}
    }
}