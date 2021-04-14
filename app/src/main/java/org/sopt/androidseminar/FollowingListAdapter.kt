package org.sopt.androidseminar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar.databinding.ItemFollowUserBinding

class FollowingListAdapter : RecyclerView.Adapter<FollowingListAdapter.FollowingUserViewHolder>() {
    val diffCallback = object : DiffUtil.ItemCallback<FollowingUserInfo>(){
        override fun areItemsTheSame(
            oldItem: FollowingUserInfo,
            newItem: FollowingUserInfo
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(
            oldItem: FollowingUserInfo,
            newItem: FollowingUserInfo
        ): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list : List<FollowingUserInfo>) = differ.submitList(list)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowingUserViewHolder {
        val binding = ItemFollowUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return FollowingUserViewHolder(binding)
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(
        holder: FollowingUserViewHolder,
        position: Int
    ) {
        val item = differ.currentList[position]
        holder.binding.setVariable(BR.data,item)
    }

    inner class FollowingUserViewHolder(val binding: ItemFollowUserBinding):
            RecyclerView.ViewHolder(binding.root)
}