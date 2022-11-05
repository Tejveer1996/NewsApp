package com.example.myapplication.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle:Bundle? = intent.extras
        val msg = bundle!!.getString("user_msg")

        //Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()

        txvUserMessage.text = msg





    }
}