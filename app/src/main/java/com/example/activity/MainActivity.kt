package com.example.activity

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adapter.UserAdapter
import com.example.databinding.ActivityMainBinding
import com.example.model.User
import com.example.util.LogUtil
import com.example.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initRecyclerView()
        userViewModel.getUser.observe(this, Observer { response ->
            userAdapter.setUser(response as ArrayList<User>)
            LogUtil.d("$response")
        })
        binding.save.setOnClickListener {
            setUserData()
        }
    }

    private fun setUserData() {
        val getName = binding.name.text.toString().trim()
        val getAge = binding.age.text.toString().trim()
        if (!TextUtils.isEmpty(getName) && !TextUtils.isEmpty(getAge)) {
            val user = User(getName, getAge.toInt())
            userViewModel.insert(user)
        } else {
            Toast.makeText(applicationContext, "Please fill all the fields",
                Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun initRecyclerView() {
        userAdapter = UserAdapter(this, ArrayList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }
}