package ru.pyroman.weatherapp.presentation.state

import ru.pyroman.weatherapp.domain.weather.WeatherInfo

sealed interface WeatherState : State {

    /**
     * Начальное состояние
     */
    object Idle : WeatherState

    /**
     * Состояние "Загрузка данных"
     */
    object Loading : WeatherState

    /**
     * Состояние "Данные загружены"
     */
    data class Loaded (
        val weatherInfo: WeatherInfo? = null,
        val errorMessage: String? = null
    ) : WeatherState
}
