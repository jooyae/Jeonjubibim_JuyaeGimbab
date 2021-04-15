package org.sopt.androidseminar

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.sopt.androidseminar.databinding.FragmentFollowingListBinding

class FollowingListFragment : Fragment() {

    lateinit var binding: FragmentFollowingListBinding
    lateinit var followingListAdapter: FollowingListAdapter
    private val followingUserInfo = mutableListOf<FollowingUserInfo>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        setGithubProfile()
    }

    private fun initRecyclerView(){
        followingListAdapter = FollowingListAdapter()
        binding.recyclerviewRepositoryList.adapter = followingListAdapter

    }
    @SuppressLint("CheckResult")
    fun setGithubProfile() {
        RetrofitService.githubApi.getRepos("jooyae")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list ->
                followingListAdapter.submitList(list)
            }, {
                it.printStackTrace()
            })


    }



}