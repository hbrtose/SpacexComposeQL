package com.hubert.spacexcomposeql.common.utils

fun Int.numberOfDigits(): Int {
    var digits = 0
    var number = this
    while (number >= 1) {
        number /= 10
        digits += 1
    }
    return digits
}
