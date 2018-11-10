package io.github.louistsaitszho.loft.common.navigationDelegate

/**
 * This exist to solve the problem of "Fragments across modules needs to be able to be able to
 * trigger something in the navigation graph without knowing where it exists
 */
interface NavigationDelegate {
    fun navigate(transition: Transition)
}

sealed class Transition {
    class WhatIs2Enter : Transition()
    class Enter2Creation : Transition()
    class Enter2Joining : Transition()
    class Joining2WaitForConfirmation : Transition()
    class Creation2Main : Transition()
}