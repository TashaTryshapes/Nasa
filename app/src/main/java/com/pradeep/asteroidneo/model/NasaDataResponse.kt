package com.pradeep.asteroidneo.model

import kotlinx.serialization.Serializable

@Serializable
data class DateModel(
    val id: String,
    val neo_reference_id: String,
    val name: String,
    val estimated_diameter: EstimatedDiameter,
    val close_approach_data: List<CloseApproachData>,
    val absolute_magnitude_h: Double
)

@Serializable
data class EstimatedDiameter(
    val kilometers: Kilometers,
    val meters: Meters,
    val miles: Miles,
    val feet: Feet
)

@Serializable
data class Kilometers(
    val estimated_diameter_min: String,
    val estimated_diameter_max: String
)

@Serializable
data class Meters(
    val estimated_diameter_min: String,
    val estimated_diameter_max: String
)

@Serializable
data class Miles(
    val estimated_diameter_min: String,
    val estimated_diameter_max: String
)

@Serializable
data class Feet(
    val estimated_diameter_min: String,
    val estimated_diameter_max: String
)

@Serializable
data class CloseApproachData(
    val close_approach_date: String,
    val close_approach_date_full: String,
    val epoch_date_close_approach: String,
    val relative_velocity: RelativeVelocity,
    val miss_distance: MissDistance,
    val orbiting_body: String,
)

@Serializable
data class RelativeVelocity(
    val kilometers_per_second: String,
    val kilometers_per_hour: String,
    val miles_per_hour: String
)

@Serializable
data class MissDistance(
    val astronomical: String,
    val lunar: String,
    val kilometers: String,
    val miles: String
)
