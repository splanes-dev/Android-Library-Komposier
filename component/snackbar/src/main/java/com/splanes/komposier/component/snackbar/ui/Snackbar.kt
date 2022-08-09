package com.splanes.komposier.component.snackbar.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.splanes.komposier.component.snackbar.state.SnackbarState
import com.splanes.komposier.component.snackbar.state.rememberSnackbarState

@Composable
fun Snackbar(
    state: SnackbarState = rememberSnackbarState(SnackbarState.None),
    modifier: Modifier = Modifier
) {

}