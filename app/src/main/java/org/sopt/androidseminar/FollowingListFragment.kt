package org.sopt.androidseminar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
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

        loadDatas()
        initRecyclerView()

    }

    private fun initRecyclerView(){
        followingListAdapter = FollowingListAdapter()
        binding.userList.adapter = followingListAdapter
        loadUserDatas()
    }

    private fun loadUserDatas() {
        followingListAdapter.submitList(followingUserInfo)
    }


    private fun loadDatas() {
        followingUserInfo.apply {
            add(
                FollowingUserInfo(
                    R.drawable.ic_home_img_step0,
                    userName = "juyae1"
                )
            )
            add(
                FollowingUserInfo(
                    R.drawable.ic_home_img_step1,
                    userName = "juyae2"
                )
            )
            add(
                FollowingUserInfo(
                    R.drawable.ic_home_img_step2,
                    userName = "juyae3"
                )
            )
            add(
                FollowingUserInfo(
                    R.drawable.ic_home_img_step3,
                    userName = "juyae4"
                )
            )
            add(
                FollowingUserInfo(
                    R.drawable.ic_home_img_step4,
                    userName = "juyae5"
                )
            )
        }

    }


}