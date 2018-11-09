package io.github.louistsaitszho.loft.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.louistsaitszho.loft.common.NavigationFragment
import io.github.louistsaitszho.loft.common.Scene
import kotlinx.android.synthetic.main.fragment_enter_loft.*

class EnterLoftFragment : NavigationFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_enter_loft, container, false)
    }

    override fun onStart() {
        super.onStart()
        fab_create_loft.setOnClickListener {
            //            findNavController().navigate(R.id.action_enterLoftFragment_to_creationFragment)
            navigationDelegate.navigate(Scene.ENTER_LOFT, Scene.CREATION)
        }
        fab_join_loft.setOnClickListener {
            //            findNavController().navigate(R.id.action_enterLoftFragment_to_joiningFragment)
            navigationDelegate.navigate(Scene.ENTER_LOFT, Scene.JOINING)
        }
    }
}