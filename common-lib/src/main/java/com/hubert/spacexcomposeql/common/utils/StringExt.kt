package com.hubert.spacexcomposeql.common.utils

import java.security.MessageDigest

val String.Companion.EMPTY: String get() = ""

fun String.sha256(): String = MessageDigest
    .getInstance(SHA_256)
    .digest(toByteArray())
    .toHexString()
    .uppercase()

fun ByteArray.toHexString(): String =
    joinToString("") { "%02x".format(it) }

private const val SHA_256 = "SHA-256"
