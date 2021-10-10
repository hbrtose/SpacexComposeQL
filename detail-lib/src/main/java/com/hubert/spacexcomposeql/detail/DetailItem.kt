package com.hubert.spacexcomposeql.detail

data class DetailItem(
    val site: String,
    val rocketName: String,
    val rocketType: String,
    val booked: Boolean,
    val name: String,
    val patch: String
)