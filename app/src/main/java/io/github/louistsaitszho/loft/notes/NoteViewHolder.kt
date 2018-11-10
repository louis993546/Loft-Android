package io.github.louistsaitszho.loft.notes

import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.louistsaitszho.loft.common.model.Note
import kotlinx.android.extensions.LayoutContainer

class NoteViewHolder(
        override val containerView: View?
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bind(note: Note) {

    }
}