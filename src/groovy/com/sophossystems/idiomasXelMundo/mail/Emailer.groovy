package com.sophossystems.idiomasXelMundo.mail
import groovy.json.JsonBuilder


class Emailer {
  String idE
  String toE
  String ccE
  String ccoE
  String subjectE
  String mensajeE
  String despedidaE
  String firmaE


  JsonBuilder getJsonEmailser() {
    JsonBuilder builder = new groovy.json.JsonBuilder()
    builder{
      id idE
      to toE
      cc ccE
      subject subjectE
      params {
        mensaje mensajeE
        despedida despedidaE
        firma firmaE
      }
    }

  }

}
