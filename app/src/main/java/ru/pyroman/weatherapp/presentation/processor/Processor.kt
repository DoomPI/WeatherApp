package ru.pyroman.weatherapp.presentation.processor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.pyroman.weatherapp.presentation.intent.Intent
import ru.pyroman.weatherapp.presentation.state.State

abstract class Processor<S : State, I : Intent> : ViewModel() {

    private val _intentFlow: MutableSharedFlow<I> = MutableSharedFlow()

    private val _initialState: S by lazy { initialState() }

    private val _viewStateFlow : MutableStateFlow<S> by lazy { MutableStateFlow(initialState()) }
    val viewStateFlow: StateFlow<S> = _viewStateFlow

    private val _longRunningJobs: Map<I, Job> = hashMapOf()

    protected abstract val reducer: Reducer<S, I>

    init {
        subscribeToIntents()
    }

    protected abstract fun initialState() : S
    protected abstract suspend fun handleIntent(intent: I, state: S) : I?

    /**
     * Отправляем новый интент
     */
    fun sendIntent(intent: I) {
        viewModelScope.launch {
            _intentFlow.emit(intent)
        }
    }


    /**
     * Обновляем state в соответствии с интентом
     */
    private fun reduceInternal(previousState: S, intent: I) {
        val newState = reducer.reduce(previousState, intent)
        setState { newState }
    }

    /**
     * Обновляем state
     */
    private fun setState(newState: S.() -> S) {
        _viewStateFlow.value = viewStateFlow.value.newState()
    }


    /**
     * Получаем интенты и отправляем на обработку
     */
    private fun subscribeToIntents() {
        viewModelScope.launch {
            _intentFlow.collect {
                reduceInternal(_viewStateFlow.value, it)
                launch {
                    handleIntent(it, _viewStateFlow.value)?.let { newIntent ->
                        sendIntent(newIntent)
                    }
                }
            }
        }
    }

    interface Reducer<S, I> {
        /**
         * Смотрим текущий state, проверяем интент и получаем новый state
         */
        fun reduce(state: S, intent: I) : S
    }
}