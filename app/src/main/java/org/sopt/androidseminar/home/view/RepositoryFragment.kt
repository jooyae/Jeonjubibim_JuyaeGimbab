package org.sopt.androidseminar.home.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import org.sopt.androidseminar.SwipeHelper
import org.sopt.androidseminar.utils.ItemDecoration
import org.sopt.androidseminar.databinding.FragmentFollowingListBinding
import org.sopt.androidseminar.home.dto.RepositoryResponseModelItem
import org.sopt.androidseminar.home.viewmodel.RepositoryViewModel
import org.sopt.androidseminar.utils.ItemDecorationRemover.removeItemDecorations

class RepositoryFragment : Fragment() {
    lateinit var binding: FragmentFollowingListBinding
    lateinit var followingListAdapter: FollowingListAdapter
    private val viewModel: RepositoryViewModel by viewModels()

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
        changeLayoutManager()
        updateRepository()
        changeItemPosition()
    }

    private fun initRecyclerView() {
        followingListAdapter =
            FollowingListAdapter(object : FollowingListAdapter.OnItemClickListener {
                override fun itemClickListener(view: View, position: Int) {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.setData(Uri.parse(viewModel.repositories.value?.get(position)?.clone_url))
                    startActivity(intent)
                }
            })
        binding.recyclerviewRepositoryList.run {
            adapter = followingListAdapter
            binding.recyclerviewRepositoryList.addItemDecoration(ItemDecoration(10, 10))
        }

    }

   private fun changeLayoutManager() {
       binding.buttonGridlayoutList.setOnClickListener{
           binding.recyclerviewRepositoryList.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
       }

       binding.buttonLinearlayoutList.setOnClickListener{
           binding.recyclerviewRepositoryList.layoutManager = LinearLayoutManager(requireContext())
       }
   }

    fun changeItemPosition() {
        val swipeHelper = SwipeHelper(object: SwipeHelper.DragItems{
            override fun changePosition(fromPosition: Int, toPosition: Int) {
                viewModel.swipeItems(fromPosition,toPosition)
                followingListAdapter.notifyItemMoved(fromPosition,toPosition)
            }
        })
        val itemTouchHelper = ItemTouchHelper(swipeHelper)
        itemTouchHelper.attachToRecyclerView(binding.recyclerviewRepositoryList)
    }

    private fun updateRepository(){
        viewModel.repositories.observe(viewLifecycleOwner){
            followingListAdapter.submitList(it)
        }
    }
}