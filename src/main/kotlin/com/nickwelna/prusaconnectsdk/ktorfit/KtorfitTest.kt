/**
 * Prusa Connect SDK for Kotlin
 * Copyright (C) 2024  Nicholas Welna
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * Contact: https://github.com/welnanick/Prusa-Connect-SDK-for-Kotlin
 */
package com.nickwelna.prusaconnectsdk.ktorfit

import de.jensklingenberg.ktorfit.Ktorfit
import kotlinx.coroutines.runBlocking
import kotlin.system.exitProcess

fun main() {
    val ktorfit = Ktorfit.Builder().baseUrl("https://swapi.dev/api/").build()
    val exampleApi = ktorfit.createExampleApi()

    val response = runBlocking {
        exampleApi.getPerson()
    }
    println(response)
    exitProcess(0)
}