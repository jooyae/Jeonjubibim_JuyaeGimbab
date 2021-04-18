package org.sopt.androidseminar.home.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.sopt.androidseminar.api.RetrofitService
import org.sopt.androidseminar.home.dto.RepositoryResponseModelItem

class RepositoryViewModel : ViewModel() {

    private val _repositories = MutableLiveData<List<RepositoryResponseModelItem>>()
    val repositories: LiveData<List<RepositoryResponseModelItem>>
        get() = _repositories

//    fun changeRepositories(list: List<RepositoryResponseModelItem>) {
//        _repositories.value = list
//    }

    init {
        setGithubProfile()
    }

    @SuppressLint("CheckResult")
    fun setGithubProfile() {
        RetrofitService.githubApi.getRepos("jooyae")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list ->
                _repositories.postValue(list)
            }, {
                it.printStackTrace()
            })
    }

}