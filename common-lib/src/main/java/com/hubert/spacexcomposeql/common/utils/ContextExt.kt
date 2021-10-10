package com.hubert.spacexcomposeql.common.utils

import android.content.Context
import androidx.core.content.pm.PackageInfoCompat

fun Context.appVersion(): Long = PackageInfoCompat.getLongVersionCode(packageManager.getPackageInfo(packageName, 0))
