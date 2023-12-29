package com.app.bluesky.control.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.app.bluesky.R
import com.app.bluesky.tools.customComposableViews.NormalButton
import com.app.bluesky.ui.theme.AppTheme

@Composable
fun WelcomeInputs(
    onCurrent: () -> Unit,
    onChoose: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        // Current Location Button
        NormalButton(
            modifier = Modifier
                .padding(top = AppTheme.dimens.paddingLarge)
                .align(CenterHorizontally)
                .fillMaxSize(),
            text = stringResource(id = R.string.current_location_button_text),
            onClick = {
                onCurrent.invoke() }
        )

        // Choose Location Button
        NormalButton(
            modifier = Modifier
                .padding(top = AppTheme.dimens.paddingLarge)
                .align(CenterHorizontally)
                .fillMaxSize(),
            text = stringResource(id = R.string.choose_location_button_text),
            onClick = onChoose
        )
    }
}