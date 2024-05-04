package com.healthykids.feature.calculate_calories.presentation

import com.healthykids.feature.calculate_calories.domain.Activity
import com.healthykids.feature.calculate_calories.domain.Age
import com.healthykids.feature.calculate_calories.domain.Sex
import com.healthykids.feature.calculate_calories.domain.WeightType

sealed class CaloriesEvent {
    data class SexListFetched(val data: MutableList<Sex>) : CaloriesEvent()
    data class AgeListFetched(val data: MutableList<Age>) : CaloriesEvent()
    data class ActivityTypeFetched(val data: MutableList<Activity>) : CaloriesEvent()
    data object ShowResultForNormalWeight : CaloriesEvent()
    data class ShowResultForOverWeight(val weightType: WeightType, val calories: Int) : CaloriesEvent()
}