package com.app.bluesky.control.choose

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.app.bluesky.R
import com.app.bluesky.tools.customComposableViews.SmallClickableWithIconAndText
import com.app.bluesky.tools.customComposableViews.TitleText
import com.app.bluesky.ui.theme.AppTheme

@Composable
fun ChooseProvinceScreen(
    onNavigateBack: () -> Unit,
    onSubmit: () -> Unit
) {
    // Full Screen Content
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .imePadding()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Back Button Icon
        SmallClickableWithIconAndText(
            modifier = Modifier
                .padding(horizontal = AppTheme.dimens.paddingLarge)
                .padding(top = AppTheme.dimens.paddingLarge),
            iconContentDescription = stringResource(id = R.string.navigate_back),
            iconVector = Icons.Filled.Home,
            text = stringResource(id = R.string.back_to_welcome),
            onClick = onNavigateBack
        )
        // Main card Content for Choose Province
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.dimens.paddingLarge)
        ) {

            Column(
                modifier = Modifier
                    .padding(horizontal = AppTheme.dimens.paddingLarge)
                    .padding(bottom = AppTheme.dimens.paddingExtraLarge)
            ) {

                // Heading Choose
                TitleText(
                    modifier = Modifier.padding(top = AppTheme.dimens.paddingLarge),
                    text = stringResource(id = R.string.choose_province_heading_text)
                )
                ChooseProvinceInputs(
                    onSubmit = onSubmit
                )
            }
        }
    }
}

@Composable
fun ChooseCityScreen(
    onNavigateBack: () -> Unit,
    onSubmit: () -> Unit
) {
    // Full Screen Content
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .imePadding()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Back Button Icon
        SmallClickableWithIconAndText(
            modifier = Modifier
                .padding(horizontal = AppTheme.dimens.paddingLarge)
                .padding(top = AppTheme.dimens.paddingLarge),
            iconContentDescription = stringResource(id = R.string.navigate_back),
            iconVector = Icons.Outlined.ArrowBack,
            text = stringResource(id = R.string.back_to_province),
            onClick = onNavigateBack
        )
        // Main card Content for Choose Province
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.dimens.paddingLarge)
        ) {

            Column(
                modifier = Modifier
                    .padding(horizontal = AppTheme.dimens.paddingLarge)
                    .padding(bottom = AppTheme.dimens.paddingExtraLarge)
            ) {
                // Heading Choose
                TitleText(
                    modifier = Modifier.padding(top = AppTheme.dimens.paddingLarge),
                    text = stringResource(id = R.string.choose_city_heading_text)
                )
                ChooseCityInputs(
                    onSubmit = onSubmit
                )
            }
        }
    }
}