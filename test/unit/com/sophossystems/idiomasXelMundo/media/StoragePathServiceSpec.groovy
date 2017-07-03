package com.sophossystems.idiomasXelMundo.media

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(StoragePathService)
class StoragePathServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Should get full url of file with an string"() {
    	given:
    		service.bucketConfig = [
    			main: [url: 'http://localhost/'],
    			secure: [url: 'https://ironbank.com/'],
    		]

    	when:
    		def result = service.getUrl(name)

    	then:
    		result == url 
    		println url

    	where:
    		prefix      | file			|| server 
    		''   	    | 'dir/img.jpg' || 'http://localhost/'
    		'main://'   | 'dir/img.jpg' || 'http://localhost/'
    		'secure://' | 'dir/img.jpg' || 'https://ironbank.com/'
    		'unknown://'| 'dir/img.jpg' || null
    		
    		name = prefix + file
    		url = server ? server + file : null
    }

    void "Should get full uri with bucket and path"(){
        given:
            service.bucketConfig = [main: [url: url]]

        when:
            def result = service.getUrl(bucketName, name)

        then:
            result ==  url + name

        where:
            name = 'dir/some-file.jpg'
            bucketName = 'main'
            url = 'http://localhost/'
    }

    void "Sould create an URI to later read a file"(){
        when:
            def result = service.createUri(bucket, path)

        then:
            result == expected 

            println result

        where:
            bucket = 'bucket'
            path = 'dir/file.pdf'
            expected = 'bucket://dir/file.pdf'
    }

    void "Sould create an URI to later read a file wihtou prefix for default bucekt"(){
        when:
            def result = service.createUri(bucket, path)

        then:
            result == path

            println result

        where:
            bucket = 'main'
            path = 'dir/file.pdf'
    }

    void "Should hashed a file name to avoid duplicates"(){
        when:
            def result = service.hashName(id, type, extension)
            def result1 =service.hashName(id, type, extension)
        then:
            result.startsWith(start)
            result.endsWith(end)

            result != result1

            println result
            println result1

        where:
            id = '1'
            type = 'Attachment'
            extension = '.jpg'

            start = '1-Attachment@'
            end = '.jpg'
    }
}
