package com.sophossystems.idiomasXelMundo.utils

import org.codehaus.groovy.grails.commons.DomainClassArtefactHandler
import grails.util.Holders

import groovy.util.logging.Log4j

@Log4j
@grails.validation.Validateable
// @deprecated since v0.6.3, use EntityReference instead
class Reference {

	final static String INVALID_DOMAIN_CLASS = 'domainClass.invalid'

	// @TODO Change signature to String
	Class domain

	// Instead of id, because id is not mapped when embedded
	Long ident 

	// Tanscient property, backward compatible
	String name

	Reference(){}

	/**
	 * Reference allows bindind with formats:
	 * 	${class.simpleName}:${id}
	 * 	${class.name}:${id}
	 */
	Reference(String ref){
		init ref
	}

	Reference(String domain, Long ident){
		init(domain, ident)
	}

	Reference(Class domain, Long ident){
		this.domain = domain
		this.ident = ident
	}

	static constraints = {
		ident 	nullable: false
		domain 	nullable: false, validator: domainValidator
	}

	static transients = ['main', 'domainName', 'name']

	static domainValidator = { val ->
		if(! DomainClassArtefactHandler.isDomainClass(val)){
			return [INVALID_DOMAIN_CLASS]
		}
	}

	// Id is alias of ident
	Long getId(){ ident }

	void setId(Long id){ 
		this.ident = id 
	}

	def getMain(){ domain?.get(ident) }

	/**
	 * Alias to bind domain by className
	 * @param name [description]
	 */
	void setDomainName(String name){
		// Test if is fully qualified domain or simple name
		if(name.contains('.')){
			// Avoid ClassNotFounException
			try {
				this.domain = Class.forName(name)
			}
			catch(ClassNotFoundException e) {
				log.warn "Class ${name}", e
			}

		}else{
			this.domain = Holders.grailsApplication.domainClasses.find { 
				it.clazz.simpleName == name 
			}?.clazz
		}
	}


	protected init(String ref){
		def tokens = ref.tokenize(':')

		if(tokens.size() == 2 && tokens[1]?.isLong()){
			init(tokens[0], tokens[1]?.toLong())
		}
	}

	protected init(String domain, Long ident){
		setDomainName domain
		setIdent ident
	}

	String toString(){
		"${domain?.simpleName}:${ident}"
	}
}
