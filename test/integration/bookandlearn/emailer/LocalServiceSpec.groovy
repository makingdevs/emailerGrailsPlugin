package bookandlearn.emailer

import spock.lang.*

/**
 *
 */
class LocalServiceSpec extends Specification {

	def localService

    def setup() {
    }

    def cleanup() {
    }

    void "Should detect locale"(){
    	expect:
    		localService.getCurrentLang() == 'en'
    }


    void "Should translate based on current locale"(){
    	expect:
    		localService.msg('facility.library') == 'Library'
    		println localService.msg('comparative.more.info')
    }
}