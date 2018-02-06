package br.com.mario.view

import br.com.mario.dao.PersonDao
import javafx.scene.control.Button
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.AnchorPane
import tornadofx.*

class LoginView : View("Login") {
    override val root: AnchorPane by fxml("/login/login.fxml")

    private val tfLogin: TextField by fxid("tf_email")
    private val tfPassword: PasswordField by fxid("tf_password")
    private val btLogin: Button by fxid("bt_login")
    private val btClose: Button by fxid("bt_close")

    private val personDao = PersonDao()

    init {

        with(root) {
        }
    }
}
