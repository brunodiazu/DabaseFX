package br.com.mario.model

data class Person(val id: Long? = null,
                  val name: String,
                  val email: String,
                  val password: String)