package com.dicoding.picodiploma.githubuser2.datasource.model

data class DetailUser(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val name: String,
    val public_repos: Int,
    val location: String,
    val followers_url: String,
    val following_url: String,
    val following: Int,
    val followers: Int
)
