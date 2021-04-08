package com.bayu.submission1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q")query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getDetailUsers(
        @Path("username")username:String
    ):Call<UserDetailResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowersUser(
        @Path("username")username:String
    ):Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowingUser(
        @Path("username")username:String
    ):Call<ArrayList<User>>
}