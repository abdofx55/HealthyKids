package com.healthykids.feature.calculate_calories.data

import com.healthykids.feature.calculate_calories.domain.Activity
import com.healthykids.feature.calculate_calories.domain.Age
import com.healthykids.feature.calculate_calories.domain.Sex
import javax.inject.Inject

open class CalculateCaloriesRepository @Inject constructor() {
    suspend fun fetchSexType() = mutableListOf(Sex.Male, Sex.Female)
    suspend fun fetchAge() =
        mutableListOf(Age.Six, Age.Seven, Age.Eight, Age.Nine, Age.Ten, Age.Eleven, Age.Twelve)

    suspend fun fetchActivityType() = mutableListOf(Activity.High, Activity.Low)
}