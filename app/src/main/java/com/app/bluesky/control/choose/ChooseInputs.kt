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
            text = stringResource(id = R.string.choose_gilan_button_text),
            onClick = {
                SharedData.SHARE.province = Province.GILAN
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
            text = stringResource(id = R.string.choose_mazandaran_button_text),
            onClick = {
                SharedData.SHARE.province = Province.MAZANDARAN
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
                Province.GILAN -> stringResource(id = R.string.choose_rasht_city_button_text)
                Province.TEHRAN -> stringResource(id = R.string.choose_tehran_city_button_text)
                Province.ALBORZ -> stringResource(id = R.string.choose_karaj_city_button_text)
                Province.MAZANDARAN -> stringResource(id = R.string.choose_sari_city_button_text)
                Province.MARKAZI -> stringResource(id = R.string.choose_arak_city_button_text)
            },
            onClick = {
                when (SharedData.SHARE.province) {
                    Province.GILAN -> {
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

                    Province.MAZANDARAN -> {
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
                Province.GILAN -> stringResource(id = R.string.choose_lahijan_city_button_text)
                Province.TEHRAN -> stringResource(id = R.string.choose_rey_city_button_text)
                Province.ALBORZ -> stringResource(id = R.string.choose_malard_city_button_text)
                Province.MAZANDARAN -> stringResource(id = R.string.choose_noor_city_button_text)
                Province.MARKAZI -> stringResource(id = R.string.choose_save_city_button_text)
            },
            onClick = {
                when (SharedData.SHARE.province) {
                    Province.GILAN -> {
                        SharedData.SHARE.lon = "37.2713"
                        SharedData.SHARE.lat = "49.5921"
                    }

                    Province.TEHRAN -> {
                        SharedData.SHARE.lon = "51.437432"
                        SharedData.SHARE.lat = "35.598883"
                    }

                    Province.ALBORZ -> {
                        SharedData.SHARE.lon = "50.979598"
                        SharedData.SHARE.lat = "35.665540"
                    }

                    Province.MAZANDARAN -> {
                        SharedData.SHARE.lon = "36.3994"
                        SharedData.SHARE.lat = "52.1912"
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
                Province.GILAN -> stringResource(id = R.string.choose_astara_city_button_text)
                Province.TEHRAN -> stringResource(id = R.string.choose_qods_city_button_text)
                Province.ALBORZ -> stringResource(id = R.string.choose_hashtgerd_city_button_text)
                Province.MAZANDARAN -> stringResource(id = R.string.choose_amol_button_text)
                Province.MARKAZI -> stringResource(id = R.string.choose_tafresh_city_button_text)
            },
            onClick = {
                when (SharedData.SHARE.province) {
                    Province.GILAN -> {
                        SharedData.SHARE.lon = "37.2713"
                        SharedData.SHARE.lat = "49.5921"
                    }

                    Province.TEHRAN -> {
                        SharedData.SHARE.lon = "51.437432"
                        SharedData.SHARE.lat = "35.598883"
                    }

                    Province.ALBORZ -> {
                        SharedData.SHARE.lon = "50.979598"
                        SharedData.SHARE.lat = "35.665540"
                    }

                    Province.MAZANDARAN -> {
                        SharedData.SHARE.lon = " 36.4696"
                        SharedData.SHARE.lat = "52.3507"
                    }

                    Province.MARKAZI -> {
                        SharedData.SHARE.lon = "49.430756"
                        SharedData.SHARE.lat = "34.043228"
                    }
                }
                onSubmit.invoke()
            }
        )
    }
}