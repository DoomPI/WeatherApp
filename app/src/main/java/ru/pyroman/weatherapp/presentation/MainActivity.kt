package ru.pyroman.weatherapp.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.pyroman.weatherapp.presentation.processor.WeatherProcessor

class MainActivity : AppCompatActivity() {

    private val processor : WeatherProcessor by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherScreenHolder(processor = processor)
        }
    }
}