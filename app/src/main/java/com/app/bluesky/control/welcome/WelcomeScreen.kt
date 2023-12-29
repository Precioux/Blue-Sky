package com.app.bluesky.control.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.app.bluesky.R
import com.app.bluesky.tools.customComposableViews.MediumTitleText
import com.app.bluesky.ui.theme.AppTheme

@Composable
fun WelcomeScreen(
    onNavigateToChoose: () -> Unit,
    onNavigateToCurrent: () -> Unit,
) {
    // Full Screen Content
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .imePadding()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Add the logo here
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(180.dp) // Adjust the size of the logo as needed
                .padding(0.dp, 0.dp, 0.dp, 16.dp) // Add padding to separate the logo from the buttons
        )
        ElevatedCard(
            colors = CardDefaults.cardColors(
                containerColor = AppTheme.colorScheme.onBackground
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.dimens.paddingLarge)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = AppTheme.dimens.paddingLarge)
                    .padding(bottom = AppTheme.dimens.paddingExtraLarge)
            ) {

                // Heading Jetpack Compose
                MediumTitleText(
                    modifier = Modifier
                        .padding(top = AppTheme.dimens.paddingLarge)
                        .fillMaxWidth(),
                    text = stringResource(id = R.string.app_name),
                    fontFamily = FontFamily.Default,
                    textAlign = TextAlign.Center,
                    color = AppTheme.colorScheme.onPrimary
                )

                WelcomeInputs(
                    onCurrent = onNavigateToCurrent,
                    onChoose = onNavigateToChoose
                )
            }
        }
    }

}