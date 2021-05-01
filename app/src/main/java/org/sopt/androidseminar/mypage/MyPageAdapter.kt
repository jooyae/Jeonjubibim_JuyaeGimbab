package org.sopt.androidseminar.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar.databinding.ActivityMyPageBinding
import org.sopt.androidseminar.databinding.ItemMypageBinding
import org.sopt.androidseminar.mypage.data.IntroData

class MyPageAdapter : RecyclerView.Adapter<MyPageAdapter.MyPageViewHolder>(){
    private val introData = mutableListOf<IntroData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageViewHolder {
        val binding = ItemMypageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyPageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyPageViewHolder, position: Int) {
        holder.bind(introData[position])
    }

    override fun getItemCount(): Int = 3

    class MyPageViewHolder(
        private val binding : ItemMypageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(introData: IntroData) {
            binding.textviewTitleMypage.text = introData.textview_Title
            binding.textviewSubtitleMypage.text = introData.textview_Subtitle
        }
    }
}