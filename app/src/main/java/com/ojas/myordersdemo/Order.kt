package com.ojas.myordersdemo

data class Order(
    val orderId: String,
    val vehicleType: String,
    val dateTime: String,
    val pickupAddress: String,
    val dropAddress: String,
    val price: Double,
    val status: String
)