package ru.pyroman.weatherapp.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import ru.pyroman.weatherapp.presentation.state.WeatherState

@Composable
fun WeatherForecast(
    state: WeatherState.Loaded,
    modifier: Modifier = Modifier,
    onShowWeeklyForecastPressed: () -> Unit
) {
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "Today",
                    fontSize = 20.sp,
                    color = Color.White
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clickable(
                            enabled = true,
                            role = Role.Button
                        ) {
                          onShowWeeklyForecastPressed.invoke()
                        },
                    text = "Next 7 Days",
                    fontSize = 18.sp,
                    style = TextStyle(
                        color = Color.White,
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(content = {
                items(data) { weatherData ->
                    HourlyWeatherDataScreen(
                        weatherData = weatherData,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
            })
        }
    }
}