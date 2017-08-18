package com.sophossystems.idiomasXelMundo.mail
import groovy.json.JsonBuilder


class TamplateEmail {
  Map destData
  Map domainParams
  String templateId

  JsonBuilder getJsonEmailser() {
    JsonBuilder builder = new groovy.json.JsonBuilder()
    builder{
      id templateId
      destData.each{ k, v -> "$k" v }
      params {
        domainParams.each{ k, v -> "$k" v }
      }
    }
  }
}
