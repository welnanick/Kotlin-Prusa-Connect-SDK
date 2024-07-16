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
package com.nickwelna.prusaconnectsdk.camera.example

import com.nickwelna.prusaconnectsdk.camera.CameraClient
import kotlinx.coroutines.runBlocking
import kotlin.system.exitProcess

/**
 * A small example showing basic usage of Camera APIs.
 */
fun main() {
    println("Enter session id:")
    val sessionId = readln()

    val client =
        CameraClient(sessionId)

    println("Enter printer UUID:")
    val printerUUID = readln()

    val response = runBlocking {
        client.createNewCamera(printerUUID)
    }
    println(response)
    exitProcess(0)
}
