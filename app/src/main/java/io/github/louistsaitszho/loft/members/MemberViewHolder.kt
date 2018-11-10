package io.github.louistsaitszho.loft.members

import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.louistsaitszho.loft.common.model.Member
import kotlinx.android.extensions.LayoutContainer

class MemberViewHolder(
        override val containerView: View?
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bind(member: Member) {

    }
}