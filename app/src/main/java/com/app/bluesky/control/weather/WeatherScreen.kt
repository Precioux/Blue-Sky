package com.app.bluesky.control.weather

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.bluesky.R
import java.time.LocalDateTime
import com.app.bluesky.control.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherScreen(
    viewModel: WeatherScreenViewModel = WeatherScreenViewModel(),
) {
    val days = viewModel.response.value
    var background = painterResource(id = R.drawable.background)
    var degree = ""
    if (days.isNotEmpty()) {
        if (days[0].pod.equals("n")) {
            background = painterResource(id = R.drawable.background)
        }
        degree = if (days[0].temp?.length!! > 1) {
            (days[0].temp?.substring(0, 1)) + "\u2103"
        } else {
            (days[0].temp) + "\u2103"
        }
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = background,
            contentDescription = "Background",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.matchParentSize()
        )
        if (days.isNotEmpty()) {
            if (!days[0].error) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 100.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    days[0].cityName?.let {
                        Text(
                            text = it,
                            fontSize = 50.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                        )
                    }
                    Text(
                        text = degree,
                        fontSize = 100.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(300.dp)
                    )

                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(3.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            for (day in days) {
                                if (day == days[0]) {
                                    continue
                                }
                                Column(
                                    modifier = Modifier
                                        .padding(16.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    val dayOfWeek = LocalDateTime.parse(day.date).dayOfWeek
                                    Text(
                                        text = dayOfWeek.name,
                                        textAlign = TextAlign.Center,
                                        color = Color.White
                                    )
                                    val degree2 = if (day.temp?.length!! > 1) {
                                        (day.temp.substring(0, 1)) + "\u2103"
                                    } else {
                                        (day.temp) + "\u2103"
                                    }
                                    LazyColumn {
                                        item {
                                            Text(
                                                text = degree2,
                                                color = Color.White
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                    var containerColor = Color.Transparent
                    var pollutionText = "Good"
                    when (days[0].pollution) {
                        1 -> containerColor = Color.Green

                        2 -> {
                            containerColor = Color.Yellow
                            pollutionText = "Fair"
                        }

                        3 -> {
                            containerColor = Color.Magenta
                            pollutionText = "Moderate"
                        }

                        4 -> {
                            containerColor = Color.Red
                            pollutionText = "Poor"
                        }

                        5 -> {
                            containerColor = Color.Black
                            pollutionText = "Very Poor"
                        }
                    }
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(3.dp)
                    ) {
                        Text(
                            text = "Pollution: $pollutionText",
                            color = containerColor
                        )
                    }
                }
            } else {
                Text(
                    text = "Error in Getting Information",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }
        }
    }

    DisposableEffect(Unit) {
        viewModel.getWeather()
        onDispose {}
    }
}