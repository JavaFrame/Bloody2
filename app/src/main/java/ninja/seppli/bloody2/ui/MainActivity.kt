package ninja.seppli.bloody2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ninja.seppli.bloody2.R

/**
 * The main activity which loads the navigation graph
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
