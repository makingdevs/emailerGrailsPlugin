package bookandlearn.emailer

import grails.transaction.Transactional
import org.springframework.web.servlet.support.RequestContextUtils 
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsWebRequest
import org.codehaus.groovy.grails.web.util.WebUtils
import org.springframework.context.NoSuchMessageException

/**
 * Helper method to deal wiht tranlations
 */
class LocalService {

	static transactional = false

    /**
     * Default language used for new users and applications
     * or when no one is given
     */
    String defaultLanguage

    /**
     * Languages that are fully translated in server and client
     */
    List<String> supportedLanguages

 	// def localeResolver
	def messageSource

	/**
	 * getCurrentLocale
	 *
	 * retuns current locale based on request. It may be used ot 
	 * @return [description]
	 */
    protected Locale getCurrentLocale(){
        GrailsWebRequest webUtils = WebUtils.retrieveGrailsWebRequest()
        def request = webUtils.getCurrentRequest()
        
        RequestContextUtils.getLocale(request)
    }

    /**
     * getCurrentLang
     *
     * return current language based on request
     * 
     * @return String curretn language code
     */
    String getCurrentLang(){
    	currentLocale.toString()
    }

    /**
     * Method to translate a code
     * @param  code 
     * @return      Translated string
     */
    def msg(String code){
    	message(code, [], currentLocale)
    }

    /**
     * Translate a key using params
     * 
     * @param  code   Code to translate
     * @param  params Params added to translation
     * @return        translatd string
     */
    def msg(String code, List<String> params){
        message(code, params, currentLocale)
    }

    /**
     * Translate a key using params and locale given
     * 
     * @param  code   Code to translate
     * @param  params Paras used in translation
     * @param  locale Locale as String for easy access
     * @return        String translated
     */
    def msg(String code, List<String> params, String locale){
        message(code, params, new Locale(locale))
    }    


    protected def message(String code, Locale locale){
        message(code, [], locale ?: currentLocale)
    }

    protected def message(String code, List<String> params, Locale locale){
        try {
            messageSource.getMessage(code, params as String[], locale)
        } catch(NoSuchMessageException ex) {
            return code
        }
 	}
}
