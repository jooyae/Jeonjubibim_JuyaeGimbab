package org.sopt.androidseminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import org.sopt.androidseminar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtonClickEvent()
    }

    private fun initButtonClickEvent() {
        binding.mainBtn.setOnClickListener {
            val userID = binding.idEdit.text
            if (userID.isNullOrBlank()) {
                Toast.makeText(
                        this@MainActivity,
                        "Id를 입력해주세요",
                        Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                        this@MainActivity,
                        "안녕하세요",
                        Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}