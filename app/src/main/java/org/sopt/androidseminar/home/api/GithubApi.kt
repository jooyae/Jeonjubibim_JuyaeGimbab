package org.sopt.androidseminar.home.api

import io.reactivex.Single
import org.sopt.androidseminar.home.dto.RepositoryResponseModelItem
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("users/{owner}/repos")
    fun getRepos(@Path("owner") owner :String) : Single<List<RepositoryResponseModelItem>>
}