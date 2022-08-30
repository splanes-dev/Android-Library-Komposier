package com.splanes.komposier.component.catalog.buttons.outlined.ui

import androidx.compose.foundation.layout.PaddingValues
import com.splanes.komposier.component.catalog.buttons.ui.ButtonIcon
import com.splanes.komposier.component.catalog.buttons.ui.ButtonSize
import com.splanes.komposier.component.catalog.buttons.ui.ButtonVisuals
import com.splanes.komposier.ui.toolkit.texts.capitalization.Capitalization

data class OutlinedButtonVisuals(
    val text: String,
    val buttonIcon: ButtonIcon?,
    override val size: ButtonSize,
    override val capitalization: Capitalization,
    override val enabled: Boolean,
    override val paddings: PaddingValues
) : ButtonVisuals
