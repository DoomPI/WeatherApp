package ru.pyroman.weatherapp.presentation.processor

import kotlinx.coroutines.delay
import ru.pyroman.weatherapp.domain.weather.WeatherInfo
import ru.pyroman.weatherapp.presentation.intent.WeatherIntent
import ru.pyroman.weatherapp.presentation.state.WeatherState

class WeatherProcessor : Processor<
        WeatherState,
        WeatherIntent>() {

    override fun initialState(): WeatherState = WeatherState.Idle

    override val reducer: Reducer<WeatherState, WeatherIntent>
        get() = WeatherReducer()

    override suspend fun handleIntent(
        intent: WeatherIntent,
        state: WeatherState
    ): WeatherIntent? = when (intent) {
        is WeatherIntent.LoadDailyForecastInfo -> {

            // Здесь мы загружаем данные о прогнозе погоды на день (например, из сети через API)

            delay(2000) // Имитация длительной загрузки для проверки UI
            val weatherInfo = WeatherInfo

            WeatherIntent.ShowDailyForecastInfo(
                weatherInfo = weatherInfo,
            ) // По окончании загрузки мы пробрасываем новый интент
        }
        is WeatherIntent.ShowDailyForecastInfo -> null // После этого нам не требуется пробрасываеть какой-либо интент
        is WeatherIntent.LoadWeeklyForecastInfo -> {

            // Здесь мы загружаем данные о прогнозе погоды на неделю (например, из сети через API)

            WeatherIntent.ShowWeeklyForecastInfo(null)
        }
        is WeatherIntent.ShowWeeklyForecastInfo -> null // После этого нам не требуется пробрасывать какой-либо интент
    }

    internal class WeatherReducer : Reducer<WeatherState, WeatherIntent> {
        override fun reduce(state: WeatherState, intent: WeatherIntent): WeatherState =
            when (intent) {
                is WeatherIntent.LoadDailyForecastInfo -> WeatherState.Loading
                is WeatherIntent.ShowDailyForecastInfo -> WeatherState.Loaded(
                    weatherInfo = intent.weatherInfo,
                )
                is WeatherIntent.LoadWeeklyForecastInfo -> WeatherState.Loading
                is WeatherIntent.ShowWeeklyForecastInfo -> WeatherState.Loaded(
                    weatherInfo = intent.weatherInfo
                )
            }
    }
}