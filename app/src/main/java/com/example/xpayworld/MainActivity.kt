package com.example.xpayworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.xpayworld.sdk.EntryPoint
import com.xpayworld.sdk.XpayLink
import com.xpayworld.sdk.XpayRequest
import kotlinx.android.synthetic.main.view_enter_amount.*
import kotlinx.android.synthetic.main.view_number_pad.*
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {


    var numpad = listOf<Button>()
    var amountStr = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numpad = listOf(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0)


        numpad.forEach { button -> button.setOnClickListener { onClickNumpad(it) } }


        btnClear.setOnClickListener {
            onClickClear(it)
        }

        btnOk.setOnClickListener {
            onClickOk(it)
        }
    }

    private fun onClickNumpad(v: View) {
        val len = amountStr.length
        if (len == 8) return
        if (len == 0 && (v as Button).text == "0") return
        amountStr += (v as Button).text

        tvAmount.text =  formattedAmount(amountStr)

    }

    private fun onClickClear(v: View) {
        amountStr = amountStr.dropLast(1)
        tvAmount.text = formattedAmount(amountStr)
    }
    private fun onClickOk(v: View) {
        if (amountStr.isEmpty()) return

            val request  = XpayRequest()
            request.appPackageName = packageName
            request.amountPurchase = ( amountStr.toInt()/100.0)
            request.entryPoint =  EntryPoint.TRANSACTION.name

            val act = XpayLink.INSTANCE.callTransaction(this,request)
            startActivity(act)
    }



    fun formattedAmount(amount : String) : String {
        var formatedAmount = ""

        if (amount == "" || amount.run { isNullOrBlank() }) {return  "0.00"}

        val len = amount.length
        val df = DecimalFormat("###,###,##0.00")
        if (len in 1..8) {
            val s = String.format("%6.2f", amount.toInt() / 100.0)
            formatedAmount = df.format(s.toDouble())
        } else if (len == 0) {
            formatedAmount = "0.00"
        }
        return formatedAmount
    }

}
