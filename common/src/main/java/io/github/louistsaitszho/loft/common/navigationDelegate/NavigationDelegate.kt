/*
 * This file is part of Loft Android Client.

 * Loft Android Client is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Loft Android Client is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Loft Android Client.  If not, see <https://www.gnu.org/licenses/>.
 */
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