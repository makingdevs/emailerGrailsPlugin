// Place your Spring DSL code here
import grails.util.Environment
import bookandlearn.emailer.*

beans = {
	
	if(Environment.current != Environment.PRODUCTION){
		mandrillService(MandrillServiceMock)
    }
}
