package br.com.mario.dao

import br.com.mario.model.Person
import br.com.mario.util.ConectionFactory
import java.sql.Connection

class PersonDao {

    private val connection: Connection by lazy {
        ConectionFactory.connection
    }

    fun add(person: Person): Boolean {
        val sql = "INSERT INTO person(name, email, password)" +
                " VALUES (?, ?, ?);"
        try {
            with(connection.prepareStatement(sql)) {
                setString(1, person.name)
                setString(2, person.email)
                setString(3, person.password)
                execute()
                close()
                connection.close()
                return true
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return false
        }
    }

    fun update(person: Person): Boolean {
        val sql = "UPDATE public.person" +
                " SET name=?, email=?, password=?" +
                " WHERE id = ?;"
        try {
            with(connection.prepareStatement(sql)) {
                setString(1, person.name)
                setString(2, person.email)
                setString(3, person.password)
                person.id?.let { setLong(4, it) }
                executeUpdate()
                close()
                connection.close()
                return true
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return false
        }
    }

    fun delete(id: Long): Boolean {
        val sql = "DELETE FROM public.person" +
                " WHERE id = ?;"
        try {
            with(connection.prepareStatement(sql)) {
                setLong(1, id)
                execute()
                close()
                connection.close()
                return true
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return false
        }
    }

    fun findAll(): List<Person> {
        val persons = ArrayList<Person>()
        val sql = "SELECT * FROM person;"

        try {
            val stmt = connection.prepareStatement(sql)
            val rs = stmt.executeQuery()

            while (rs.next()) {
                persons.add(Person(id = rs.getLong("id"),
                        name = rs.getString("name"),
                        email = rs.getString("email"),
                        password = rs.getString("password")))
            }

            stmt.close()
            rs.close()
            connection.close()

        } catch (ex: Exception) {
            ex.printStackTrace()
            return emptyList()
        }

        return persons
    }
}