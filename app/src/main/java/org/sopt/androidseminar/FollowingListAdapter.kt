package org.sopt.androidseminar

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar.databinding.ItemFollowUserBinding

class FollowingListAdapter(val listener: OnItemClickListener) : RecyclerView.Adapter<FollowingListAdapter.FollowingUserViewHolder>() {
    val diffCallback = object : DiffUtil.ItemCallback<RepositoryResponseModelItem>(){
        override fun areItemsTheSame(
            oldItem: RepositoryResponseModelItem,
            newItem: RepositoryResponseModelItem
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(
            oldItem: RepositoryResponseModelItem,
            newItem: RepositoryResponseModelItem
        ): Boolean {
            return oldItem == newItem
        }

    }

    interface OnItemClickListener{
        fun itemClickListener(view: View, position: Int)
    }

    val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list : List<RepositoryResponseModelItem>) = differ.submitList(list)

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

        holder.binding.constraintlayoutItemGithub.setOnClickListener{
            listener.itemClickListener(holder.binding.root, position)
        }
    }

    inner class FollowingUserViewHolder(val binding: ItemFollowUserBinding):
            RecyclerView.ViewHolder(binding.root)
}