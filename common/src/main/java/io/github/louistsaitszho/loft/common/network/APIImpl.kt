package io.github.louistsaitszho.loft.common.network

import io.github.louistsaitszho.loft.common.network.dto.CreateLoftResponse
import io.github.louistsaitszho.loft.common.network.dto.NoteListResponse
import io.github.louistsaitszho.loft.common.network.dto.RequestJoinLoftResponse

class APIImpl : API {
    override suspend fun createLoft(loftName: String, userName: String): CreateLoftResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun requestJoinLoft(loftCode: String, userName: String): RequestJoinLoftResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getNotes(): NoteListResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}