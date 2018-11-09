package io.github.louistsaitszho.loft.common

/**
 * This exception will be thrown when [NavigationFragment] can't attach itself to
 * [NavigationDelegate]
 *
 * @param contextClassName is the name of the context that [NavigationFragment] gets during onAttach
 */
class NoNavigationDelegateException(
        contextClassName: String
) : RuntimeException("$contextClassName must implement NavigationDelegate")