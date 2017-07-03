package com.sophossystems.idiomasXelMundo.media

/**
 * Service to mange all files storage logic
 * Is able to save in local disk or external services like S3
 */
class StoragePathService {

    /**
     * The format to persist filenames is:
     * 
     *     <bucket>://<uri>
     *     agency://some/image.jpg
     *     
     */
    static final String BUCKET_SEPARATOR = '://'
    static final String BUCKET_SEPARATOR_REGEX = /\:\/\//

    static final String NAME_SEPARATOR = '-'
    static final String HASH_SEPARATOR = '@'

    /**
     * Main storage bucket configuration should be declared as
     *
     *  storage.buckets.main = [:]
     */
    static final String DEFAULT_BUCKET = 'main'

    /**
     * Path to save temporary files
     */
    static final String TEMPORARY_DIR = 'tmp'

    /**
     * Main configuration to know the bucket location
     */
    Map bucketConfig

    /**
     * Fallback to load buckets from app config
     */
    def grailsApplication

    /**
     * Convert an string to a full URL where the file is located
     * The strign mush have the <bucket>://<uri> format
     * When no bucket is given, DEFAULT_BUCKET is used
     * 
     * @param  filename 
     * @return         
     */
    String getUrl(String uri) {
        def config = tokenize(uri)

        getUrl(config.bucket, config.name)
    }

    /**
     * Return URL using the given bucekt config and path
     * @param  bucketName 
     * @param  path       
     * @return            
     */
    String getUrl(String bucketName, String path){
        def bucket = findBucket(bucketName)

        (bucket) ? bucket.url + path : null
    }

    /**
     * Return a full uri that should be persisted to read and write later
     * Contains bucket name as prefix when the bucket is other thatn the main
     * @param  bucket 
     * @param  path   
     * @return        
     */
    String createUri(String bucket, String path){
        String prefix = bucket == DEFAULT_BUCKET ? '' : bucket + BUCKET_SEPARATOR

        prefix + path
    }
 
    /**
     * Return buckets from internal config if exists or grailsApplication
     * @return Map with buckets
     */
    Map getBuckets(){
        bucketConfig ?: grailsApplication?.config?.storage?.buckets
    }

    /**
     * Hash a name to allow having multiple files of the given type
     */
    String hashName(String id, String type, String extension){
        String key = id + NAME_SEPARATOR + type

        hashName(key, extension)
    }

    /**
     * Has a name using key and preserving extension
     * @param  key       Key to be hashed
     * @param  extension 
     * @return           
     */
    String hashName(String key, String extension){
        hashString(key) + extension
    }

    /**
     * Return a bucket config for the given name
     * If no bucket is given, defautlBucket is returned
     * @param  name 
     * @return      
     */
    Map findBucket(String name){
        getBuckets()[name]
    }

    /**
     * Convert a formated uri into a map with name and bucekt info
     * @param  name [description]
     * @return      [description]
     */
    protected Map tokenize(String uri){
        List parts = uri?.split(BUCKET_SEPARATOR_REGEX)
        Map out = [:]

        if(parts.size == 1){
            out.name = uri
            out.bucket = DEFAULT_BUCKET
        }

        if(parts.size == 2){
            out.name = parts[1]
            out.bucket = parts[0]
        }

        return out
    }

    /**
     * Add a suffix to avoid filename collisions    
     * 
     * @param  base 
     * @return      
     */
    protected String hashString(String reference){
        String uuid = UUID.randomUUID().toString()

        // Return a reference with its uuid
        reference + HASH_SEPARATOR + uuid.replace('-', '')
    }
}
