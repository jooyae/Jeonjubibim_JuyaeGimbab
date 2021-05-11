package org.sopt.androidseminar.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import org.sopt.androidseminar.api.reqres.ReqresCreator
import org.sopt.androidseminar.api.reqres.dto.RequestReqresUsers
import org.sopt.androidseminar.api.reqres.dto.ResponseReqresUsers
import org.sopt.androidseminar.userinfo.UserInfoActivity
import org.sopt.androidseminar.databinding.ActivityHomeBinding
import org.sopt.androidseminar.home.viewmodel.ReqresListViewModel
import org.sopt.androidseminar.mypage.MyPageActivity
import retrofit2.Call
import retrofit2.Callback

class HomeActivity : AppCompatActivity() {
    lateinit var binding : ActivityHomeBinding
    lateinit var reqresListAdapter: ReqresListAdapter
    private val viewModel by viewModels<ReqresListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.getFriendsList(2)
        initButtonClick()
        showReqresList()
    }

    fun initButtonClick(){
        binding.buttonHomeMore.setOnClickListener {
            val intent = Intent(this@HomeActivity , UserInfoActivity::class.java)
            intent.putExtra("name", binding.textviewProfileId.text.toString())
            startActivity(intent)
        }
        binding.textviewHomeGallery.setOnClickListener{
            val intent = Intent(this@HomeActivity, MyPageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun showReqresList(){
        reqresListAdapter = ReqresListAdapter()
        binding.recyclerviewReqresUsers.adapter = reqresListAdapter

        viewModel.reqreslist.observe(this){
            viewModel.reqreslist.value?.forEach {
                reqresListAdapter.reqresList.add(it)
                reqresListAdapter.notifyDataSetChanged()
            }
        }
    }







}