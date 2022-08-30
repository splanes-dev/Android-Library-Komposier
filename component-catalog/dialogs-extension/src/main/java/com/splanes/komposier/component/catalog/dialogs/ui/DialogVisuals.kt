package com.splanes.komposier.component.catalog.dialogs.ui

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogProperties
import com.splanes.komposier.component.catalog.dialogs.defaults.DialogDefaults
import com.splanes.komposier.ui.toolkit.anims.transitions.TransitionSet
import com.splanes.komposier.ui.toolkit.anims.transitions.setWith

data class DialogVisuals(
    val content: String,
    val confirmButtonText: String,
    val title: String? = null,
    val icon: ImageVector? = null,
    val iconSize: Dp = DialogDefaults.IconSize,
    val titleLayout: DialogTitleLayout = LayoutColumn,
    val transition: TransitionSet = DialogDefaults.EnterAnim setWith DialogDefaults.ExitAnim,
    val dismissButtonText: String? = null,
    val properties: DialogProperties = DialogProperties(),
    val elevation: Dp = DialogDefaults.TonalElevation
) {
    companion object
}

val DialogVisuals.Companion.LayoutRowCentered get() = DialogTitleLayout.Row(isSpaceBetween = true)
val DialogVisuals.Companion.LayoutRow get() = DialogTitleLayout.Row()
val DialogVisuals.Companion.LayoutColumn get() = DialogTitleLayout.Column
