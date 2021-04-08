package com.bayu.submission1

data class UserDetailResponse(
    val login: String,
    val avatar_url: String,
    val name: String,
    val following: Int,
    val followers: Int,
    val public_repos:Int,
    val company:String,
    val location:String
)