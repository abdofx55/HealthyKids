package com.healthykids.feature.calculate_calories.presentation

import androidx.lifecycle.viewModelScope
import com.example.healthykids.R
import com.healthykids.core.base.BaseCoroutineDispatchers
import com.healthykids.core.base.BaseViewModel
import com.healthykids.feature.calculate_calories.data.CalculateCaloriesRepository
import com.healthykids.feature.calculate_calories.domain.Activity
import com.healthykids.feature.calculate_calories.domain.Age
import com.healthykids.feature.calculate_calories.domain.Sex
import com.healthykids.feature.calculate_calories.domain.WeightType
import com.healthykids.utils.Message
import com.healthykids.utils.databinding.ObservableEditText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.pow

@HiltViewModel
class CaloriesViewModel @Inject constructor(
    private val repository: CalculateCaloriesRepository, dispatchers: BaseCoroutineDispatchers
) : BaseViewModel<CaloriesEvent>(dispatchers) {

    val name = ObservableEditText()
    val sex = ObservableEditText()
    val age = ObservableEditText()
    val height = ObservableEditText()
    val weight = ObservableEditText()
    val activity = ObservableEditText()

    init {
        fetchSexType()
        fetchAge()
        fetchActivityType()
    }

    private fun fetchSexType() {
        viewModelScope.launch {
            pushSingle(CaloriesEvent.SexListFetched(repository.fetchSexType()))
        }
    }

    private fun fetchAge() {
        viewModelScope.launch {
            pushSingle(CaloriesEvent.AgeListFetched(repository.fetchAge()))
        }
    }

    private fun fetchActivityType() {
        viewModelScope.launch {
            pushSingle(CaloriesEvent.ActivityTypeFetched(repository.fetchActivityType()))
        }
    }

    private fun determineWeightType(): WeightType {
        val bmi =
            weight.userInput.get().toDouble() / (height.userInput.get().toDouble() / 100).pow(2.0)
        return if (bmi <= 18.5)
            WeightType.UnderWeight
        else if (bmi > 18.5 && bmi < 25.0)
            WeightType.NormalWeight
        else if (bmi >= 25 && bmi < 30)
            WeightType.OverWeight
        else if (bmi >= 30)
            WeightType.Obesity
        else
            WeightType.None
    }

    fun calculateCalories() {
        if (isDataValid()) {
            val weightType = determineWeightType()

            if (weightType == WeightType.UnderWeight || weightType == WeightType.NormalWeight) {
                pushSingle(CaloriesEvent.ShowResultForNormalWeight)
                return
            }

            if (weightType == WeightType.OverWeight || weightType == WeightType.Obesity) {
                var calories = 0
                when (age.userInput.get()) {
                    Age.Six.getName() ->
                        calories = calculateCaloriesFromSex(1400, 1600, 1200, 1400)

                    Age.Seven.getName() ->
                        calories = calculateCaloriesFromSex(1400, 1600, 1200, 1600)

                    Age.Eight.getName() ->
                        calories = calculateCaloriesFromSex(1400, 1600, 1400, 1600)

                    Age.Nine.getName() ->
                        calories = calculateCaloriesFromSex(1600, 1800, 1400, 1600)

                    Age.Ten.getName() ->
                        calories = calculateCaloriesFromSex(1600, 1800, 1400, 1800)

                    Age.Eleven.getName() ->
                        calories = calculateCaloriesFromSex(1800, 2000, 1600, 1800)

                    Age.Twelve.getName() ->
                        calories = calculateCaloriesFromSex(1800, 2200, 1600, 2000)
                }
                pushSingle(CaloriesEvent.ShowResultForOverWeight(weightType, calories))
            }
        }
    }

    private fun calculateCaloriesFromSex(
        maleLow: Int,
        maleHigh: Int,
        femaleLow: Int,
        femaleHigh: Int
    ): Int {
        return when (sex.userInput.get()) {
            Sex.Male.getName() -> calculateCaloriesFromActivity(maleLow, maleHigh)
            Sex.Female.getName() -> calculateCaloriesFromActivity(femaleLow, femaleHigh)
            else -> 0
        }
    }

    private fun calculateCaloriesFromActivity(low: Int, high: Int): Int {
        return when (activity.userInput.get()) {
            Activity.High.getName() -> low
            Activity.Low.getName() -> high
            else -> 0
        }
    }

    private fun isDataValid(): Boolean {
        val isNameValid: Boolean
        val isSexValid: Boolean
        val isAgeValid: Boolean
        val isHeightValid: Boolean
        val isWeightValid: Boolean
        val isActivityValid: Boolean

        if (name.userInput.get().isNotEmpty()) {
            name.error.set(Message(R.string.empty))
            isNameValid = true
        } else {
            isNameValid = false
            name.error.set(Message(R.string.field_required))
        }

        if (sex.userInput.get().isNotEmpty()) {
            sex.error.set(Message(R.string.empty))
            isSexValid = true
        } else {
            isSexValid = false
            sex.error.set(Message(R.string.field_required))
        }

        if (age.userInput.get().isNotEmpty()) {
            age.error.set(Message(R.string.empty))
            isAgeValid = true
        } else {
            isAgeValid = false
            age.error.set(Message(R.string.field_required))
        }

        if (height.userInput.get().isNotEmpty()) {
            height.error.set(Message(R.string.empty))
            isHeightValid = true
        } else {
            isHeightValid = false
            height.error.set(Message(R.string.field_required))
        }

        if (weight.userInput.get().isNotEmpty()) {
            weight.error.set(Message(R.string.empty))
            isWeightValid = true
        } else {
            isWeightValid = false
            weight.error.set(Message(R.string.field_required))
        }

        if (activity.userInput.get().isNotEmpty()) {
            activity.error.set(Message(R.string.empty))
            isActivityValid = true
        } else {
            isActivityValid = false
            activity.error.set(Message(R.string.field_required))
        }


        return isNameValid && isSexValid && isAgeValid && isHeightValid && isWeightValid && isActivityValid
    }

    fun onSexSelected(sex: Sex) {
        this.sex.userInput.set(sex.getName())
    }

    fun onAgeSelected(age: Age) {
        this.age.userInput.set(age.getName())
    }

    fun onActivitySelected(activity: Activity) {
        this.activity.userInput.set(activity.getName())
    }

}