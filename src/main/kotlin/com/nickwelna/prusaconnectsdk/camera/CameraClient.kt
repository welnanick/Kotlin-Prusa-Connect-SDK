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
package com.nickwelna.prusaconnectsdk.camera

import com.nickwelna.prusaconnectsdk.camera.api.Camera
import com.nickwelna.prusaconnectsdk.camera.api.createCameraApi
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.cookies.ConstantCookiesStorage
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.http.Cookie
import io.ktor.http.CookieEncoding
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy

/**
 * Client class for interacting with the Prusa Connect Camera API.
 *
 * @param sessionId The sessionId value to place within the Cookie header to authenticate the requests made with this client.
 */
class CameraClient(sessionId: String) {
    @OptIn(ExperimentalSerializationApi::class)
    val ktorClient: HttpClient = HttpClient {
        install(HttpCookies) {
            storage = ConstantCookiesStorage(
                Cookie(
                    name = "SESSID",
                    value = sessionId,
                    domain = "connect.prusa3d.com",
                    encoding = CookieEncoding.DQUOTES
                )
            )
        }
        install(ContentNegotiation) {
            json(Json {
                namingStrategy = JsonNamingStrategy.SnakeCase
            })
        }
    }
    val cameraApiClient =
        Ktorfit.Builder().baseUrl("https://connect.prusa3d.com/").httpClient(ktorClient).build().createCameraApi()

    /**
     * Creates a new camera for a specific printer.
     *
     * @param printerUuid the UUID of the printer that the camera should be created for.
     */
    suspend fun createNewCamera(printerUuid: String): Camera = cameraApiClient.createCamera(printerUuid)
}