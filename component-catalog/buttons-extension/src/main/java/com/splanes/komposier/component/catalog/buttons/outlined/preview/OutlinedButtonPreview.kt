package com.splanes.komposier.component.catalog.buttons.outlined.preview

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.splanes.komposier.component.catalog.buttons.ButtonDefaults
import com.splanes.komposier.component.catalog.buttons.ButtonPreviewScaffold
import com.splanes.komposier.component.catalog.buttons.logClick
import com.splanes.komposier.component.catalog.buttons.outlined.OutlinedButton
import com.splanes.komposier.component.catalog.buttons.ui.ButtonSize

@Composable
@Preview(name = "Simple")
fun Simple() {
    ButtonPreviewScaffold(alignment = Alignment.Start) {
        ButtonSize.values().forEachIndexed { index, size ->
            OutlinedButton(
                modifier = Modifier.padding(top = if (index != 0) 8.dp else 0.dp),
                buttonUi = ButtonDefaults.outlinedButton(text = "Button ${size.name}", size = size),
                onClick = ::logClick
            )
        }
    }
}
