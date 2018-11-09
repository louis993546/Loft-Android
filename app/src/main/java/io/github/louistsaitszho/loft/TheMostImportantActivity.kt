package io.github.louistsaitszho.loft

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController
import io.github.louistsaitszho.loft.common.NavigationDelegate
import io.github.louistsaitszho.loft.common.Scene

/**
 * This is the one and only activity in the app. Everything lives on Fragments, navigation via the
 * Navigation AAC, and this is the activity that hosts all of them.
 *
 * Other notes:
 * - I don't think I need to care about onSaveInstanceState here (at least for now)
 */
class TheMostImportantActivity : AppCompatActivity(), NavigationDelegate {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_most_important)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()

    override fun navigate(from: Scene, to: Scene) {
        val actionId = when {
            from == Scene.WHAT_IS_LOFT && to == Scene.ENTER_LOFT ->
                R.id.action_whatIsLoftFragment_to_enterLoftFragment
            from == Scene.ENTER_LOFT && to == Scene.CREATION ->
                R.id.action_enterLoftFragment_to_creationFragment
            from == Scene.ENTER_LOFT && to == Scene.JOINING ->
                R.id.action_enterLoftFragment_to_joiningFragment
            else -> TODO("something else")
        }
        findNavController(R.id.nav_host_fragment).navigate(actionId)
    }
}
