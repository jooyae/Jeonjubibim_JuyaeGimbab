package org.sopt.androidseminar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidseminar.databinding.FragmentFollowingListBinding

class FollowingListFragment : Fragment() {

    lateinit var binding: FragmentFollowingListBinding

    lateinit var followingListAdapter: FollowingListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFollowingListBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_following_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        followingListAdapter = FollowingListAdapter()

        binding.userList.adapter = followingListAdapter

        followingListAdapter.userList.addAll(
            listOf<FollowingUserInfo>(
                FollowingUserInfo(
                    userImage = "@drawable/tiger",
                    userName = "juyae"
                ),
                FollowingUserInfo(
                    userImage = "@drawable/tiger",
                    userName = "juyae2"
                ),
                FollowingUserInfo(
                    userImage = "@drawable/tiger",
                    userName = "juyae3"
                ),
                FollowingUserInfo(
                    userImage = "@drawable/tiger",
                    userName = "juyae4"
                )
            )
        )
        followingListAdapter.notifyDataSetChanged()
    }


}