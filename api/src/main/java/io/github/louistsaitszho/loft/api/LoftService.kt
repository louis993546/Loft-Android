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
package io.github.louistsaitszho.loft.api

import io.github.louistsaitszho.loft.api.dto.PostJoinLoftBody
import io.github.louistsaitszho.loft.api.dto.PostJoinLoftResponse
import io.github.louistsaitszho.loft.api.dto.PostNoteBody
import io.github.louistsaitszho.loft.api.dto.PostNoteResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * TODO pretty much all of the return types are still in design
 * TODO https://github.com/square/retrofit/pull/2886 when it's ready
 *
 * API definition that retrofit needs
 */
internal interface LoftService {
    @POST("loft/{loft_id}/request")
    fun postJoinLoftRequest(
            @Path("loft_id") loftId: String,
            @Body body: PostJoinLoftBody
    ): Deferred<PostJoinLoftResponse>

    @POST("loft/{loft_id}/notes")
    fun postNote(
            @Header(value = "auth?") token: String,
            @Body body: PostNoteBody
    ): Deferred<PostNoteResponse>
}

