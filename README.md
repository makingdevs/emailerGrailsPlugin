# Toolkit Email Template

This plugin is a module extracted from [server-app](https://bitbucket.org/bookandlearn/server-app/overview), and it's part of the same app.

## Deployment

The plugin is deployed in [Nexus](http://nexus.masterkeyeducation.com). So if you are ready to deploy, please change the version in **ToolkitPdfEmailGrailsPlugin.groovy**, after that, in your console:

`grails  maven-deploy -repository=pluginReleases`

## Configuration

In the config file

```
# Because the module is using Mandrill plugin
mandrill.apiKey=MANDRILLAPIKEY
# IMPORTANT! Set this on your config file
grails.plugin.mailer.defaultAddress=mail@mail.com
grails.plugin.mailer.defaultSender=default@mail.com
```

Enjoy! :smile: