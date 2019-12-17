package com.xpayworld.sdk

import com.google.gson.annotations.SerializedName

class  XpayRequest {

    @SerializedName("merchant_name")
    var merchantName = ""

    @SerializedName("transaction_id")
    var transactionId = ""

    /*
    SWIPE(0),
    INSERT(1),
    TAP(2),
    SWIPE_OR_INSERT(3),
    SWIPE_OR_TAP(4),
    SWIPE_OR_INSERT_OR_TAP(5),
    INSERT_OR_TAP(6)
    */

    @SerializedName("card_capture_method")
    var cardCaptureMethod : Int = 5

    @SerializedName("amount_purchase")
    var amountPurchase = 0.00

    @SerializedName("staff_id")
    var staffId = ""

    @SerializedName("app_package_name")
    var appPackageName = ""

    @SerializedName("transaction_currency")
    var currencySign = ""

    @SerializedName("transaction_code")
    var currencyNumber = ""

    @SerializedName("transaction_connection")
    var isOffline = false
}
