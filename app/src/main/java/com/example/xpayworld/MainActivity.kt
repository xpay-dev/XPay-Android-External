package com.example.xpayworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xpayworld.sdk.EntryPoint
import com.xpayworld.sdk.XpayLink
import com.xpayworld.sdk.XpayRequest
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        //    val request = XpayRequest()
//            val request  = XpayRequest()
//            request.appPackageName = packageName
//            request.amountPurchase = 10005
//            request.entryPoint =  EntryPoint.TRANSACTION.name
//
//            val act = XpayLink.INSTANCE.callTransaction(this,request)
//            startActivity(act)


    }
}
