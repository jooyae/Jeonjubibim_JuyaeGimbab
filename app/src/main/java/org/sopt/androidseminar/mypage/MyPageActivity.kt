package org.sopt.androidseminar.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import org.sopt.androidseminar.R
import org.sopt.androidseminar.databinding.ActivityMyPageBinding
import org.sopt.androidseminar.mypage.data.IntroData

class MyPageActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyPageBinding
    lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showViewPager()
        setMyPageAdapter()
    }

    private fun showViewPager() {
        viewPager = binding.viewpagerMypage
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> IntroData(
                        imageview_Intro = "",
                        textview_Title = "성장하고 싶은 개발자",
                        textview_Subtitle = "SWU dept of Sotfware Convergence"
                    )
                    1 -> IntroData(
                        imageview_Intro = "",
                        textview_Title = "도전을 무서워하지 않는 개발자",
                        textview_Subtitle = "BE SOPT ANDROID"
                    )
                    2 -> IntroData(
                        imageview_Intro = "",
                        textview_Title = "Learn To Share, Share To Learn",
                        textview_Subtitle = "주예로이드 화이팅 >_<"
                    )

                }
            }
        })
    }
    private fun setMyPageAdapter(){
        val myPageAdapter = MyPageAdapter()
        binding.viewpagerMypage.adapter = myPageAdapter
        binding.dotsindicatorMypage.setViewPager2(binding.viewpagerMypage)
    }

}