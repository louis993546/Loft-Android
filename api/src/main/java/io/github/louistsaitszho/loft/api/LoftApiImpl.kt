package io.github.louistsaitszho.loft.api

import io.github.louistsaitszho.loft.api.dto.CreateLoftResponse
import io.github.louistsaitszho.loft.api.dto.NoteListResponse
import io.github.louistsaitszho.loft.api.dto.RequestJoinLoftResponse

class LoftApiImpl : LoftApi {
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