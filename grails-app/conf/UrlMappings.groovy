class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/emailer/sendNotify"(controller: "senderNotify", action: "index", method: "POST")

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
