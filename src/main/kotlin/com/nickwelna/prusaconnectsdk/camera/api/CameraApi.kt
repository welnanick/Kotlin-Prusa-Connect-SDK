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
package com.nickwelna.prusaconnectsdk.camera.api

import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.Path

/**
 * This interface contains the Camera related API calls found in PrusaConnect.
 */
interface CameraApi {
    /**
     * Creates a new camera for the provided printer.
     *
     * @param printerUuid the UUID of the printer the camera should be created for.
     */
    @POST("app/printers/{printer_uuid}/camera")
    suspend fun createCamera(@Path("printer_uuid") printerUuid: String): Camera
}