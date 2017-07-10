#!/usr/bin/env groovy

// Call grails command in non interactive mode
def grails(String cmd, String pipe = ''){
  sh "./grailsw ${cmd} --plain-output --non-interactive ${pipe}"
}

// Create branch links
def branch(String br){
  def repo = 'https://bitbucket.org/bookandlearn/server-app/branch'
  return "<${repo}/${br}|${br}>"
}

pipeline {
  agent any

  tools {
    jdk "JDK_7u79"
  }

  stages {
    stage('Start') {
      steps {
        bitbucketStatusNotify(buildState: 'INPROGRESS')
      }
    }

    stage('Clean and compile') {
      steps {
        grails 'test clean'
        grails 'test compile'
        sh 'rm -fR target/test-reports'
      }
    }

    stage('Test') {
      steps{
        grails 'test-app'
      }
    }
  }

  post {
    always {
      archive "target/**/*"
      junit 'target/**/*'
    }

    success {
      bitbucketStatusNotify(buildState: 'SUCCESSFUL')
    }

    failure {
      bitbucketStatusNotify(buildState: 'FAILED')
    }
  }
}
