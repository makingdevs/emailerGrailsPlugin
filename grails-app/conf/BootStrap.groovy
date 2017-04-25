class BootStrap {

	def mailerService

    def init = { servletContext ->

    	assert mailerService.defaultSender
    }
    def destroy = {
    }
}
