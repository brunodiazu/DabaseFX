package br.com.mario.util

import java.sql.Connection
import java.sql.DriverManager

class ConectionFactory {

    companion object {
        val USER: String = "postgres"
        val PASSWORD: String = "Pkg1522pam"
        val SERVER: String = "localhost"
        val DATABASE: String = "databaseFX"

        val connection: Connection by lazy {
            DriverManager.getConnection("jdbc:postgresql://$SERVER/$DATABASE", USER, PASSWORD)
        }
    }
}
