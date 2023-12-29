package com.app.bluesky.control.choose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.app.bluesky.R
import com.app.bluesky.tools.customComposableViews.NormalButton
import com.app.bluesky.model.Province
import com.app.bluesky.model.SharedData
import com.app.bluesky.ui.theme.AppTheme

@Composable
fun ChooseProvinceInputs(
    onSubmit: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        NormalButton(
            modifier = Modifier
                .padding(top = AppTheme.dimens.paddingExtraLarge)
                .align(CenterHorizontally),
            text = stringResource(id = R.string.choose_qazvin_button_text),
            onClick = {
                SharedData.SHARE.province = Province.QAZVIN
                onSubmit.invoke()
            }
        )
        NormalButton(
            modifier = Modifier
                .padding(top = AppTheme.dimens.paddingExtraLarge)
                .align(CenterHorizontally),
            text = stringResource(id = R.string.choose_tehran_button_text),
            onClick = {
                SharedData.SHARE.province = Province.TEHRAN
                onSubmit.invoke()
            }
        )
        NormalButton(
            modifier = Modifier
                .padding(top = AppTheme.dimens.paddingExtraLarge)
                .align(CenterHorizontally),
            text = stringResource(id = R.string.choose_qom_button_text),
            onClick = {
                SharedData.SHARE.province = Province.QOM
                onSubmit.invoke()
            }
        )
        NormalButton(
            modifier = Modifier
                .padding(top = AppTheme.dimens.paddingExtraLarge)
                .align(CenterHorizontally),
            text = stringResource(id = R.string.choose_alborz_button_text),
            onClick = {
                SharedData.SHARE.province = Province.ALBORZ
                onSubmit.invoke()
            }
        )
        NormalButton(
            modifier = Modifier
                .padding(top = AppTheme.dimens.paddingExtraLarge)
                .align(CenterHorizontally),
            text = stringResource(id = R.string.choose_markazi_button_text),
            onClick = {
                SharedData.SHARE.province = Province.MARKAZI
                onSubmit.invoke()
            }
        )
    }
}

@Composable
fun ChooseCityInputs(
    onSubmit: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        NormalButton(
            modifier = Modifier
                .padding(top = AppTheme.dimens.paddingExtraLarge)
                .align(CenterHorizontally),
            text = when (SharedData.SHARE.province) {
                Province.QAZVIN -> stringResource(id = R.string.choose_qazvin_city_button_text)
                Province.TEHRAN -> stringResource(id = R.string.choose_tehran_city_button_text)
                Province.ALBORZ -> stringResource(id = R.string.choose_karaj_city_button_text)
                Province.QOM -> stringResource(id = R.string.choose_qom_city_button_text)
                Province.MARKAZI -> stringResource(id = R.string.choose_arak_city_button_text)
            },
            onClick = {
                when (SharedData.SHARE.province) {
                    Province.QAZVIN -> {
                        SharedData.SHARE.lon = "50.007392"
                        SharedData.SHARE.lat = "36.284530"
                    }

                    Province.TEHRAN -> {
                        SharedData.SHARE.lon = "51.375994"
                        SharedData.SHARE.lat = "35.688911"
                    }

                    Province.ALBORZ -> {
                        SharedData.SHARE.lon = "50.994806"
                        SharedData.SHARE.lat = "35.817931"
                    }

                    Province.QOM -> {
                        SharedData.SHARE.lon = "50.886193"
                        SharedData.SHARE.lat = "34.646120"
                    }

                    Province.MARKAZI -> {
                        SharedData.SHARE.lon = "49.692298"
                        SharedData.SHARE.lat = "34.092817"
                    }
                }
                onSubmit.invoke()
            }
        )
        NormalButton(
            modifier = Modifier
                .padding(top = AppTheme.dimens.paddingExtraLarge)
                .align(CenterHorizontally),
            text = when (SharedData.SHARE.province) {
                Province.QAZVIN -> stringResource(id = R.string.choose_alvand_city_button_text)
                Province.TEHRAN -> stringResource(id = R.string.choose_rey_city_button_text)
                Province.ALBORZ -> stringResource(id = R.string.choose_malard_city_button_text)
                Province.QOM -> stringResource(id = R.string.choose_kohak_city_button_text)
                Province.MARKAZI -> stringResource(id = R.string.choose_save_city_button_text)
            },
            onClick = {
                when (SharedData.SHARE.province) {
                    Province.QAZVIN -> {
                        SharedData.SHARE.lon = "50.069579"
                        SharedData.SHARE.lat = "36.189306"
                    }

                    Province.TEHRAN -> {
                        SharedData.SHARE.lon = "51.437432"
                        SharedData.SHARE.lat = "35.598883"
                    }

                    Province.ALBORZ -> {
                        SharedData.SHARE.lon = "50.979598"
                        SharedData.SHARE.lat = "35.665540"
                    }

                    Province.QOM -> {
                        SharedData.SHARE.lon = "50.865053"
                        SharedData.SHARE.lat = "34.395700"
                    }

                    Province.MARKAZI -> {
                        SharedData.SHARE.lon = "49.430756"
                        SharedData.SHARE.lat = "34.043228"
                    }
                }
                onSubmit.invoke()
            }
        )
        NormalButton(
            modifier = Modifier
                .padding(top = AppTheme.dimens.paddingExtraLarge)
                .align(CenterHorizontally),
            text = when (SharedData.SHARE.province) {
                Province.QAZVIN -> stringResource(id = R.string.choose_takestan_city_button_text)
                Province.TEHRAN -> stringResource(id = R.string.choose_qods_city_button_text)
                Province.ALBORZ -> stringResource(id = R.string.choose_hashtgerd_city_button_text)
                Province.QOM -> stringResource(id = R.string.choose_jafar_city_button_text)
                Province.MARKAZI -> stringResource(id = R.string.choose_tafresh_city_button_text)
            },
            onClick = {
                when (SharedData.SHARE.province) {
                    Province.QAZVIN -> {
                        SharedData.SHARE.lon = "49.695847"
                        SharedData.SHARE.lat = "36.070638"
                    }
                    Province.TEHRAN -> {
                        SharedData.SHARE.lon = "51.111508"
                        SharedData.SHARE.lat = "35.717866"
                    }
                    Province.ALBORZ -> {
                        SharedData.SHARE.lon = "50.685104"
                        SharedData.SHARE.lat = "35.962252"
                    }
                    Province.QOM -> {
                        SharedData.SHARE.lon = "51.220913"
                        SharedData.SHARE.lat = "35.342413"
                    }
                    Province.MARKAZI -> {
                        SharedData.SHARE.lon = "50.341066"
                        SharedData.SHARE.lat = "35.043964"
                    }
                }
                onSubmit.invoke()
            }
        )
    }
}