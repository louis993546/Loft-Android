package io.github.louistsaitszho.loft.common.model

import java.util.*

data class Member(
        val id: UUID,
        val name: String,
        val token: String? = null
        //TODO photo id of some sort
)