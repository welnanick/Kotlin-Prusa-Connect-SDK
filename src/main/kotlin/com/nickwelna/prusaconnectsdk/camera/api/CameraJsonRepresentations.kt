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

import kotlinx.serialization.Serializable

@Serializable
data class Camera(
    val id: Int,
    val name: String? = null,
    val config: CameraConfig? = null,
    val options: CameraOptions? = null,
    val capabilities: Array<CameraCapabilities>? = null,
    val teamId: Int,
    val printerUUID: String,
    val token: String? = null,
    val origin: CameraOrigin,
    val deleted: Int? = null,
    val registered: Boolean,
    val sortOrder: Int? = null
)

@Serializable
data class CameraConfig(
    val cameraId: String? = null,
    val path: String? = null,
    val name: String,
    val driver: String? = null,
    val triggerScheme: TriggerScheme? = null,
    val resolution: CameraResolution? = null,
    val networkInfo: CameraNetworkInformation? = null,
)

@Serializable
enum class TriggerScheme {
    MANUAL, EACH_LAYER, FIFTH_LAYER, GCODE, TEN_SEC, THIRTY_SEC, SIXTY_SEC, TEN_MIN
}

@Serializable
data class CameraResolution(val width: Int, val height: Int)

@Serializable
data class CameraNetworkInformation(
    val lanMac: String? = null,
    val lanIpv4: String? = null,
    val lanIpv6: String? = null,
    val wifiMac: String? = null,
    val wifiIpv4: String? = null,
    val wifiIpv6: String? = null,
    val wifiSsid: String? = null,
)

@Serializable
data class CameraOptions(val availableResolutions: Array<CameraResolution>)

@Serializable
enum class CameraCapabilities {
    TRIGGER_SCHEME, IMAGING, RESOLUTION, FOCUS
}

@Serializable
enum class CameraOrigin {
    LINK, WEB, OTHER
}
