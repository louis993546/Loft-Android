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
package io.github.louistsaitszho.loft.notes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PagedList
import io.github.louistsaitszho.loft.common.ScopedViewModel
import io.github.louistsaitszho.loft.common.model.Note

class NotesViewModel(private val repository: NotesRepository) : ScopedViewModel() {
    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

    private val pagedList = MutableLiveData<PagedList<Note>>()

    fun addNote(note: Note) {
        //add note to repository
    }

    fun refresh() {

    }

//    fun getNotePages(): LiveData<PagedList<Note>> {
//
//    }
}

sealed class State

data class NoNotes(val something: String) : State()

data class HasNotes(val notes: List<Note>) : State()