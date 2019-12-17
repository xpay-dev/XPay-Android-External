package com.xpayworld.sdk

import android.content.Context
import android.content.Intent

interface  ITransCall{
    fun callTransaction(context: Context, params : XpayRequest): Intent

}