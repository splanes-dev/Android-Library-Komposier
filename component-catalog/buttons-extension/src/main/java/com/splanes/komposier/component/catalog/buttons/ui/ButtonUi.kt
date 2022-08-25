package com.splanes.komposier.component.catalog.buttons.ui

import androidx.compose.foundation.layout.PaddingValues
import com.splanes.komposier.ui.toolkit.texts.capitalization.Capitalization

internal interface ButtonUi {
    val size: ButtonSize
    val capitalization: Capitalization
    val enabled: Boolean
    val paddings: PaddingValues
}