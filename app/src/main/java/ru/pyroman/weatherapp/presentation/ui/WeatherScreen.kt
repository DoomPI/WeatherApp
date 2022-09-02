package ru.pyroman.weatherapp.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.pyroman.weatherapp.presentation.state.WeatherState
import ru.pyroman.weatherapp.presentation.ui.theme.DarkBlue
import ru.pyroman.weatherapp.presentation.ui.theme.DeepBlue
import ru.pyroman.weatherapp.presentation.ui.theme.WeatherAppTheme

@Composable
fun WeatherScreen(
    state: WeatherState,
    onStarted: () -> Unit,
    onShowWeeklyForecastPressed: () -> Unit
) {

    WeatherAppTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            when (state) { // Изменяем UI в зависимости от state
                is WeatherState.Loaded -> { // Данные загружены, отображаем их
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(DarkBlue)
                    ) {
                        WeatherCard(
                            state = state,
                            backgroundColor = DeepBlue
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        WeatherForecast(
                            state = state,
                            onShowWeeklyForecastPressed = onShowWeeklyForecastPressed
                        )
                    }
                }
                is WeatherState.Loading -> { // Данные ещё загружаются, отображаем прогресс индикатор
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                is WeatherState.Idle -> { // Начальное состояние, запускаем onStarted
                    onStarted.invoke()
                }
            }
        }
    }

}