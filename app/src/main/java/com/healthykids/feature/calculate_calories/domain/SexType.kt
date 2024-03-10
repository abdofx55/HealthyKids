package com.healthykids.feature.calculate_calories.domain

enum class SexType {
    Male{
        override fun getName() = "ذكر"
    },
    Female{
        override fun getName() = "ذكر"
    };

    abstract fun getName(): String
}