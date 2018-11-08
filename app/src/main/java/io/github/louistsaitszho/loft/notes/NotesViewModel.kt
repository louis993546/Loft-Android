package io.github.louistsaitszho.loft.notes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PagedList
import io.github.louistsaitszho.loft.common.ScopedViewModel

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