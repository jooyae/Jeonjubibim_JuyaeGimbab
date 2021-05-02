package org.sopt.androidseminar.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import org.sopt.androidseminar.R
import org.sopt.androidseminar.databinding.ActivityMyPageBinding
import org.sopt.androidseminar.uploadImage

class MyPageActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyPageBinding
    private var fragment: ImageSlideFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageSlideFragment = fragment
        val transaction = supportFragmentManager.beginTransaction()
        if (imageSlideFragment != null) {
            transaction.add(R.id.fragment_imageslide, imageSlideFragment)
        }
        transaction.commit()

        val pagerAdapter = ScreenSlideMyPageAdapter(this)
        binding.viewpagerMypage.adapter = pagerAdapter

    }

        private inner class ScreenSlideMyPageAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
            override fun getItemCount(): Int = 3

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> ImageSlideFragment(R.drawable.myphoto)
                    1 -> ImageSlideFragment(R.drawable.myprofile)
                    else -> ImageSlideFragment(R.drawable.ic_home_img_step4)
                }
            }
        }


}