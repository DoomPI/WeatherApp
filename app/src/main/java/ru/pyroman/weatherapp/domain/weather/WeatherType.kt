package ru.pyroman.weatherapp.domain.weather

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.pyroman.weatherapp.R

sealed class WeatherType(
    @StringRes val weatherDescriptionResId: Int,
    @DrawableRes val iconResId: Int
) {
    object ClearSky : WeatherType(
        weatherDescriptionResId = R.string.clear_sky,
        iconResId = R.drawable.ic_sunny
    )
    object MainlyClear : WeatherType(
        weatherDescriptionResId = R.string.mainly_clear,
        iconResId = R.drawable.ic_cloudy
    )
    object PartlyCloudy : WeatherType(
        weatherDescriptionResId = R.string.partly_cloudy,
        iconResId = R.drawable.ic_cloudy
    )
    object Overcast : WeatherType(
        weatherDescriptionResId = R.string.overcast,
        iconResId = R.drawable.ic_cloudy
    )
    object Foggy : WeatherType(
        weatherDescriptionResId = R.string.foggy,
        iconResId = R.drawable.ic_very_cloudy
    )
    object DepositingRimeFog : WeatherType(
        weatherDescriptionResId = R.string.depositing_rime_fog,
        iconResId = R.drawable.ic_very_cloudy
    )
    object LightDrizzle : WeatherType(
        weatherDescriptionResId = R.string.light_drizzle,
        iconResId = R.drawable.ic_rainshower
    )
    object ModerateDrizzle : WeatherType(
        weatherDescriptionResId = R.string.moderate_drizzle,
        iconResId = R.drawable.ic_rainshower
    )
    object DenseDrizzle : WeatherType(
        weatherDescriptionResId = R.string.dense_drizzle,
        iconResId = R.drawable.ic_rainshower
    )
    object LightFreezingDrizzle : WeatherType(
        weatherDescriptionResId = R.string.slight_freezing_drizzle,
        iconResId = R.drawable.ic_snowyrainy
    )
    object DenseFreezingDrizzle : WeatherType(
        weatherDescriptionResId = R.string.dense_freezing_drizzle,
        iconResId = R.drawable.ic_snowyrainy
    )
    object SlightRain : WeatherType(
        weatherDescriptionResId = R.string.slight_rain,
        iconResId = R.drawable.ic_rainy
    )
    object ModerateRain : WeatherType(
        weatherDescriptionResId = R.string.moderate_rain,
        iconResId = R.drawable.ic_rainy
    )
    object HeavyRain : WeatherType(
        weatherDescriptionResId = R.string.heavy_rain,
        iconResId = R.drawable.ic_rainy
    )
    object HeavyFreezingRain: WeatherType(
        weatherDescriptionResId = R.string.heavy_freezing_rain,
        iconResId = R.drawable.ic_snowyrainy
    )
    object SlightSnowFall: WeatherType(
        weatherDescriptionResId = R.string.slight_snow_fall,
        iconResId = R.drawable.ic_snowy
    )
    object ModerateSnowFall: WeatherType(
        weatherDescriptionResId = R.string.moderate_snow_fall,
        iconResId = R.drawable.ic_heavysnow
    )
    object HeavySnowFall: WeatherType(
        weatherDescriptionResId = R.string.heavy_snow_fall,
        iconResId = R.drawable.ic_heavysnow
    )
    object SnowGrains: WeatherType(
        weatherDescriptionResId = R.string.snow_grains,
        iconResId = R.drawable.ic_heavysnow
    )
    object SlightRainShowers: WeatherType(
        weatherDescriptionResId = R.string.slight_rain_showers,
        iconResId = R.drawable.ic_rainshower
    )
    object ModerateRainShowers: WeatherType(
        weatherDescriptionResId = R.string.moderate_rain_showers,
        iconResId = R.drawable.ic_rainshower
    )
    object ViolentRainShowers: WeatherType(
        weatherDescriptionResId = R.string.violent_rain_showers,
        iconResId = R.drawable.ic_rainshower
    )
    object SlightSnowShowers: WeatherType(
        weatherDescriptionResId = R.string.slight_snow_showers,
        iconResId = R.drawable.ic_snowy
    )
    object HeavySnowShowers: WeatherType(
        weatherDescriptionResId = R.string.heavy_snow_showers,
        iconResId = R.drawable.ic_snowy
    )
    object ModerateThunderstorm: WeatherType(
        weatherDescriptionResId = R.string.moderate_thunderstorm,
        iconResId = R.drawable.ic_thunder
    )
    object SlightHailThunderstorm: WeatherType(
        weatherDescriptionResId = R.string.thunderstorm_with_slight_hail,
        iconResId = R.drawable.ic_rainythunder
    )
    object HeavyHailThunderstorm: WeatherType(
        weatherDescriptionResId = R.string.thunderstorm_with_heavy_hail,
        iconResId = R.drawable.ic_rainythunder
    )
}
