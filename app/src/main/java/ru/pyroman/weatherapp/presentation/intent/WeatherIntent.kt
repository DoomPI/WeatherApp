package ru.pyroman.weatherapp.presentation.intent

import ru.pyroman.weatherapp.domain.weather.WeatherInfo

sealed interface WeatherIntent : Intent {
    /**
     * Интент загрузить данные о прогнозе погоды на день
     */
    object LoadDailyForecastInfo : WeatherIntent

    /**
     * Интент вывести данные о прогнозе погоды на день
     */
    data class ShowDailyForecastInfo(
        val weatherInfo: WeatherInfo
    ) : WeatherIntent

    /**
     * Интент загрузить данные о прогнозе погоды на неделю
     */
    object LoadWeeklyForecastInfo : WeatherIntent

    /**
     * Интент вывести данные о прогонзе погоды на неделю
     */
    data class ShowWeeklyForecastInfo(
        val weatherInfo: WeatherInfo?
    ) : WeatherIntent
}