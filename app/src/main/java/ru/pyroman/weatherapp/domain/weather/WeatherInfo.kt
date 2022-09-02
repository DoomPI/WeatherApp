package ru.pyroman.weatherapp.domain.weather

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

/**
 * В нормальном проекте должен быть дата классом, т.е. моделью,
 * данные которой мы можем получить например из API.
 * Здесь я использую болванку-object для проверки UI
 */
object WeatherInfo {
    val weatherDataPerDay: Map<Int, List<WeatherData>> = mapOf(
        0 to listOf(
            WeatherData(
                time = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0)),
                temperatureCelsius = 20.2,
                pressure = 1013.0,
                windSpeed = 6.0,
                humidity = 35.0,
                weatherType = WeatherType.ClearSky
            ),
            WeatherData(
                time = LocalDateTime.of(LocalDate.now(), LocalTime.of(1, 0)),
                temperatureCelsius = 19.9,
                pressure = 1013.0,
                windSpeed = 6.0,
                humidity = 35.0,
                weatherType = WeatherType.ClearSky
            ),
            WeatherData(
                time = LocalDateTime.of(LocalDate.now(), LocalTime.of(2, 0)),
                temperatureCelsius = 19.4,
                pressure = 1013.0,
                windSpeed = 6.0,
                humidity = 35.0,
                weatherType = WeatherType.MainlyClear
            ),
            WeatherData(
                time = LocalDateTime.of(LocalDate.now(), LocalTime.of(3, 0)),
                temperatureCelsius = 19.0,
                pressure = 1013.0,
                windSpeed = 6.0,
                humidity = 35.0,
                weatherType = WeatherType.MainlyClear
            ),
            WeatherData(
                time = LocalDateTime.of(LocalDate.now(), LocalTime.of(4, 0)),
                temperatureCelsius = 19.1,
                pressure = 1013.0,
                windSpeed = 6.0,
                humidity = 35.0,
                weatherType = WeatherType.MainlyClear
            ),
            WeatherData(
                time = LocalDateTime.of(LocalDate.now(), LocalTime.of(5, 0)),
                temperatureCelsius = 19.4,
                pressure = 1013.0,
                windSpeed = 6.0,
                humidity = 35.0,
                weatherType = WeatherType.MainlyClear
            ),
        )

    )
    val currentWeatherData: WeatherData = WeatherData(
        time = LocalDateTime.now(),
        temperatureCelsius = 30.2,
        pressure = 1013.0,
        windSpeed = 6.0,
        humidity = 35.0,
        weatherType = WeatherType.Overcast
    )
}