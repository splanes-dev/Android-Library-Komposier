package com.splanes.komposier.component.catalog.buttons.filled.ui

import androidx.compose.foundation.layout.PaddingValues
import com.splanes.komposier.component.catalog.buttons.ui.ButtonIcon
import com.splanes.komposier.component.catalog.buttons.ui.ButtonSize
import com.splanes.komposier.component.catalog.buttons.ui.ButtonUi
import com.splanes.komposier.ui.toolkit.texts.capitalization.Capitalization

data class FilledButtonUi(
    val text: String,
    val buttonIcon: ButtonIcon?,
    override val size: ButtonSize,
    override val capitalization: Capitalization,
    override val enabled: Boolean,
    override val paddings: PaddingValues
) : ButtonUi