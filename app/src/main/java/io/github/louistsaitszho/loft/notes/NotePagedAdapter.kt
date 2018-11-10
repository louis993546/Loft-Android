package io.github.louistsaitszho.loft.notes

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.louistsaitszho.loft.R
import io.github.louistsaitszho.loft.common.model.Note

/**
 * TODO different types of note requires different types of ViewHolder
 * - text only
 * - Image only
 * - etc?
 */
class NotePagedAdapter : PagedListAdapter<Note, NoteViewHolder>(NoteDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            NoteViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.viewholder_note,
                    parent,
                    false
            ))

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        getItem(position)?.run { holder.bind(this) }
    }

    companion object {
        private val NoteDiffCallback = object : DiffUtil.ItemCallback<Note>() {
            override fun areItemsTheSame(oldItem: Note?, newItem: Note?) =
                    oldItem?.id == newItem?.id

            override fun areContentsTheSame(oldItem: Note?, newItem: Note?) =
                    oldItem == newItem

        }
    }
}