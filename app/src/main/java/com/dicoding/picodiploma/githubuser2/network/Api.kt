package com.dicoding.picodiploma.githubuser2.network

import com.dicoding.picodiploma.githubuser2.BuildConfig
import com.dicoding.picodiploma.githubuser2.datasource.model.DetailUser
import com.dicoding.picodiploma.githubuser2.datasource.model.User
import com.dicoding.picodiploma.githubuser2.datasource.model.UserSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers(
        "Authorization: token ${BuildConfig.API_KEY}")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserSearch>

    @GET("users/{username}")
    @Headers(
        "Authorization: token ${BuildConfig.API_KEY}")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUser>

    @GET("users/{username}/followers")
    @Headers(
        "Authorization: token ${BuildConfig.API_KEY}")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers(
        "Authorization: token ${BuildConfig.API_KEY}")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}