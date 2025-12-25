package com.bsoft.navigation3test.naviagation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route: NavKey {
    @Serializable
    data object Todolist: Route, NavKey

    @Serializable
    data class TodolistDetail(val todo: String): Route, NavKey
}