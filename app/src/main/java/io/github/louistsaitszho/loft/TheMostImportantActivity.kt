package io.github.louistsaitszho.loft

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController

/**
 * This is the one and only activity in the app. Everything lives on Fragments, navigation via the
 * Navigation AAC, and this is the activity that hosts all of them.
 */
class TheMostImportantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_most_important)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()
}
