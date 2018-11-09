package io.github.louistsaitszho.loft.common

/**
 * This exist to solve the problem of "Fragments across modules needs to be able to be able to
 * trigger something in the navigation graph without knowing where it exists
 *
 * TODO 1 navigate(from, to) vs 1 fun for each action
 */
interface NavigationDelegate {
    //TODO need a way to pass parameter
    fun navigate(from: Scene, to: Scene)
}

enum class Scene {
    ENTER_LOFT,
    CREATION,
    JOINING,
    WHAT_IS_LOFT
}