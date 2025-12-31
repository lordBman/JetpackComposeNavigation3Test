package com.bsoft.navigation3test.naviagation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route: NavKey {
    @Serializable
    data object Auth: Route{
        @Serializable
        data object Login: Route
        @Serializable
        data object Register: Route
    }

    @Serializable
    data object Todo: Route{
        @Serializable
        data object Todolist: Route

        @Serializable
        data class TodolistDetail(val todo: String): Route
    }
}