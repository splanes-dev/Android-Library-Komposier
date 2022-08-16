package com.splanes.komposier.uitheme.theme.defaults.shapes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.splanes.komposier.uitheme.theme.defaults.textstyles.LatoApercuTextStyles
import com.splanes.komposier.uitheme.theme.models.shapes.ThemeShapes

internal object RoundedShapes : ThemeShapes {
    override val extraSmall: CornerBasedShape = RoundedCornerShape(size = 2.dp)
    override val small: CornerBasedShape = RoundedCornerShape(size = 4.dp)
    override val medium: CornerBasedShape = RoundedCornerShape(size = 8.dp)
    override val large: CornerBasedShape = RoundedCornerShape(size = 16.dp)
    override val extraLarge: CornerBasedShape = RoundedCornerShape(size = 24.dp)
}

@Composable
@Preview(name = "Rounded Shapes Preview", showBackground = true, backgroundColor = 0xFFFFFFFF)
private fun RoundedShapesPreview() {
    with(RoundedShapes) {
        Column(modifier = Modifier.fillMaxSize()) {
            Surface(modifier = Modifier.padding(top = 8.dp), shape = extraSmall, color = Color(0xFFB3B3B3)) {
                Box(modifier = Modifier.size(width = 12.dp, height = 8.dp), contentAlignment = Alignment.Center) {
                    Text("Shape extra small")
                }
            }
            Surface(modifier = Modifier.padding(top = 8.dp), shape = small, color = Color(0xFFB3B3B3)) {
                Box(modifier = Modifier.size(width = 16.dp, height = 16.dp), contentAlignment = Alignment.Center) {
                    Text("Shape small")
                }
            }
            Surface(modifier = Modifier.padding(top = 8.dp), shape = medium, color = Color(0xFFB3B3B3)) {
                Box(modifier = Modifier.size(width = 32.dp, height = 24.dp), contentAlignment = Alignment.Center) {
                    Text("Shape medium")
                }
            }
            Surface(modifier = Modifier.padding(top = 8.dp), shape = large, color = Color(0xFFB3B3B3)) {
                Box(modifier = Modifier.size(width = 46.dp, height = 32.dp), contentAlignment = Alignment.Center) {
                    Text("Shape large")
                }
            }
            Surface(modifier = Modifier.padding(top = 8.dp), shape = extraLarge, color = Color(0xFFB3B3B3)) {
                Box(modifier = Modifier.fillMaxWidth().height(52.dp), contentAlignment = Alignment.Center) {
                    Text("Shape extra large")
                }
            }

        }
    }
}