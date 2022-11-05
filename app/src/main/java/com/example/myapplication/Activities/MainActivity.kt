package com.example.myapplication.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.showToast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        

        btnShowToast.setOnClickListener {
            Log.i("Main Activity", "Button was Clicked !")
            showToast("ShowToast Button was Clicked !")//Extension of showToast
           // Toast.makeText(this,"ShowToast Button was Clicked !",Toast.LENGTH_SHORT).show()

        }
       btnSendMsgToNextActivity.setOnClickListener {
           val message: String = etUserMessage.text.toString()
           val intent =  Intent(this, SecondActivity::class.java)
           intent.putExtra("user_msg",message)
           startActivity(intent)
       }

        btnShareToOtherApp.setOnClickListener {

            val message: String = "My Message is:"+etUserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type= "text/plain"
            startActivity(Intent.createChooser(intent,"Select the App: "))
        }

        btnRecyclerView.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }

        btnNews.setOnClickListener {
            val intent = Intent(this,NewsActivity::class.java)
            startActivity(intent)
        }


     }
    }





