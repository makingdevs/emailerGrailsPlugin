package bookandlearn.emailer

import org.springframework.web.multipart.MultipartFile

/**
 * Attachment
 * A domain class describes the data object and it's mapping to the database
 */
class Attachment {
	
	def storagePathService

	String path
	String name
	
	String mime

	String referenceDomain

	def file

	void setFile(MultipartFile file){
		this.file = file
		this.mime = file.contentType
        this.size = file.getSize()
		this.name = file.originalFilename
	}

    String getFullPath(){
    	// attachmentService?.basePath + path
    }
}