package com.bsoft.navigation3test.naviagation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route: NavKey {
    @Serializable
    data object Auth: Route, NavKey{
        @Serializable
        data object Login: Route, NavKey
        @Serializable
        data object Register: Route, NavKey
    }

    @Serializable
    data object Todo: Route, NavKey{
        @Serializable
        data object Todolist: Route, NavKey

        @Serializable
        data class TodolistDetail(val todo: String): Route, NavKey
    }
}