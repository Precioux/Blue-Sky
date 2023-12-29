package com.app.bluesky.tools.customComposableViews

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import com.app.bluesky.ui.theme.*

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = AppTheme.typography.headlineLarge,
        color = AppTheme.colorScheme.primary
    )
}

@Composable
fun MediumTitleText(
    modifier: Modifier = Modifier,
    text: String,
    fontFamily: FontFamily = FontFamily.Default,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = AppTheme.colorScheme.primary
) {
    Text(
        modifier = modifier,
        text = text,
        style = AppTheme.typography.headlineMedium,
        color = color,
        fontFamily = fontFamily,
        textAlign = textAlign
    )
}