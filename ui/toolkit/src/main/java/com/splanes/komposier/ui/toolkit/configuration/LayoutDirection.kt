package com.splanes.komposier.ui.toolkit.configuration

import android.content.res.Configuration
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.LayoutDirection

fun Configuration.layoutDirection(): LayoutDirection = when (layoutDirection) {
    View.LAYOUT_DIRECTION_RTL -> LayoutDirection.Rtl
    View.LAYOUT_DIRECTION_LTR -> LayoutDirection.Ltr
    else -> error("Unexpected layout direction value get from current LocalConfiguration")
}

@Composable
fun layoutDirection(): LayoutDirection = LocalConfiguration.current.layoutDirection()
