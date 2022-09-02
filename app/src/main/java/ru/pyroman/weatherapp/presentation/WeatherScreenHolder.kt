package ru.pyroman.weatherapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.pyroman.weatherapp.presentation.intent.WeatherIntent
import ru.pyroman.weatherapp.presentation.processor.WeatherProcessor
import ru.pyroman.weatherapp.presentation.ui.WeatherScreen

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun WeatherScreenHolder(
    processor: WeatherProcessor
) {
    val state by processor.viewStateFlow.collectAsStateWithLifecycle()

    WeatherScreen(
        state = state,
        onStarted = {
            processor.sendIntent(WeatherIntent.LoadDailyForecastInfo)
        },
        onShowWeeklyForecastPressed = {
            processor.sendIntent(WeatherIntent.LoadWeeklyForecastInfo)
        }
    )
}