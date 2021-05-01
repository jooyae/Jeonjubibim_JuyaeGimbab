package org.sopt.androidseminar.mypage

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar.databinding.ActivityMyPageBinding
import org.sopt.androidseminar.mypage.data.IntroData

class MyPageAdapter : RecyclerView.Adapter<MyPageAdapter.MyPageViewHolder>(){
    private val introList = mutableListOf<IntroData>()

    class MyPageViewHolder(private val binding : ActivityMyPageBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(introList : IntroData){

                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyPageViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = 3
}