package io.github.louistsaitszho.loft.common

/**
 * This exist to solve the problem of "Fragments across modules needs to be able to be able to
 * trigger something in the navigation graph without knowing where it exists
 */
interface NavigationDelegate {
    fun navigate(transition: Transition)
}

sealed class Transition {
    class WhatIsToEnter : Transition()
    class EnterToCreation : Transition()
    class EnterToJoining : Transition()
    class Joining2WaitForConfirmation : Transition()
}