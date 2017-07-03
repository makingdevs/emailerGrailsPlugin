package com.sophossystems.idiomasXelMundo.media

/**
 * AttachmentType is used to organize attachment
 * One domain can have different attachment types and
 * it's used to automatically link and attachment to a domain
 */
enum AttachmentType {

	Icon,

	Image,

	FeaturedImage,

	Brochure,

	Contract
	
	String getKey(){
		toString()[0].toLowerCase() +  toString().substring(1)
	}
}
