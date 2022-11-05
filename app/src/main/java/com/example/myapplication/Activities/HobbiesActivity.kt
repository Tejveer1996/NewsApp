package com.example.myapplication.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.HobbiesAdapter
import com.example.myapplication.R
import com.example.myapplication.Supplier
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        // linking custom adapter with recyclerView
        val layoutManager = LinearLayoutManager(this) //defining layoutManager for recyclerView
        layoutManager.orientation= LinearLayoutManager.VERTICAL
        recyclerView.layoutManager= layoutManager

        //initialization of hobbies adapter
        val adapter = HobbiesAdapter(this, Supplier.hobbies)
        recyclerView.adapter= adapter

    }
}