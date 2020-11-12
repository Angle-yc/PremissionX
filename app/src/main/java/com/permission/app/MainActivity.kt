package com.permission.app

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.permission.angle.PermissionX
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeCallBtn.setOnClickListener {
            requestPermission()
//            startActivity(Intent(this@MainActivity,SecondActivity::class.java))
        }
    }

    fun requestPermission(){
        PermissionX.request(this,
            Manifest.permission.CALL_PHONE){
                allGranted,deniedList ->
            if (allGranted){
                call()
            }else {
                Toast.makeText(this,"You denied $deniedList",Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun call(){
        try {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}