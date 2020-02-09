@file:JvmName("Main")
package org.example

import com.dlsc.formsfx.model.structure.Field
import com.dlsc.preferencesfx.PreferencesFx
import com.dlsc.preferencesfx.model.Category
import com.dlsc.preferencesfx.model.Setting
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

fun main(vararg args: String) {
    launch<MainApp>(*args)
}

class MainApp : App(MainView::class)

class MainView : View("PreferencesFX Test") {
    override val root = anchorpane {
        button("Show Preferences") {
            action {
                PreferencesFx.of(Settings::class.java,
                    Category.of("General",
                        Setting.of("Username", Settings.usernameProperty),
                        Setting.of("Password",
                            Field.ofPasswordType(Settings.passwordProperty),
                            Settings.passwordProperty
                        )
                    )
                ).show()
            }
        }
    }
}

object Settings {
    val usernameProperty = SimpleStringProperty("username")
    val passwordProperty = SimpleStringProperty("password")
}
