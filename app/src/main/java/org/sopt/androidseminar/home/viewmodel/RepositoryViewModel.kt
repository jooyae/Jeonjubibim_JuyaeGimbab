package org.sopt.androidseminar.home.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.sopt.androidseminar.api.RetrofitService
import org.sopt.androidseminar.home.dto.RepositoryResponseModelItem
import org.sopt.androidseminar.home.dto.ResponseGithubRepository
import org.sopt.androidseminar.home.view.RepositoryFragment

class RepositoryViewModel : ViewModel() {

    private val _repositories = MutableLiveData<ResponseGithubRepository>()
    val repositories: LiveData<ResponseGithubRepository>
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

    fun swipeItems(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                _repositories.value!![i + 1] = _repositories.value!![i]
                _repositories.value!![i] = _repositories.value!![i + 1]
            }
        } else {
            for (i in fromPosition until toPosition + 1) {
                _repositories.value!![i - 1] = _repositories.value!![i]
                _repositories.value!![i] = _repositories.value!![i + 1]
            }
        }
    }

}