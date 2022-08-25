package com.splanes.komposier.component.catalog.buttons.filled.preview

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.splanes.komposier.component.catalog.buttons.ButtonDefaults
import com.splanes.komposier.component.catalog.buttons.ButtonPreviewScaffold
import com.splanes.komposier.component.catalog.buttons.filled.FilledButton
import com.splanes.komposier.component.catalog.buttons.logClick
import com.splanes.komposier.component.catalog.buttons.ui.ButtonIcon
import com.splanes.komposier.component.catalog.buttons.ui.ButtonSize

@Composable
@Preview(name = "Simple")
fun Simple() {
    ButtonPreviewScaffold(alignment = Alignment.Start) {
        ButtonSize.values().forEachIndexed { index, size ->
            FilledButton(
                modifier = Modifier.padding(top = if (index != 0) 8.dp else 0.dp),
                buttonUi = ButtonDefaults.filledButton(text = "Button ${size.name}", size = size),
                onClick = ::logClick
            )
        }
    }
}

@Composable
@Preview(name = "Leading Icon")
fun LeadingIcon() {
    ButtonPreviewScaffold(alignment = Alignment.Start) {
        ButtonSize.values().forEachIndexed { index, size ->
            FilledButton(
                modifier = Modifier.padding(top = if (index != 0) 8.dp else 0.dp),
                buttonUi = ButtonDefaults.filledButton(
                    text = "Button ${size.name}",
                    icon = ButtonDefaults.iconButton(icon = Icons.Rounded.AddCircle),
                    size = size
                ),
                onClick = ::logClick
            )
        }
    }
}

@Composable
@Preview(name = "Trailing Icon")
fun TrailingIcon() {
    ButtonPreviewScaffold(alignment = Alignment.Start) {
        ButtonSize.values().forEachIndexed { index, size ->
            FilledButton(
                modifier = Modifier.padding(top = if (index != 0) 8.dp else 0.dp),
                buttonUi = ButtonDefaults.filledButton(
                    text = "Button ${size.name}",
                    icon = ButtonDefaults.iconButton(
                        icon = Icons.Rounded.AddCircle,
                        position = ButtonIcon.Trailing
                    ),
                    size = size
                ),
                onClick = ::logClick
            )
        }
    }
}
