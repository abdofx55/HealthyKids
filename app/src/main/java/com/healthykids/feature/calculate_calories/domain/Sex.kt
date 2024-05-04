package com.healthykids.feature.calculate_calories.domain

enum class Sex {
    Male {
        override fun getName() = "ذكر"
    },
    Female {
        override fun getName() = "أنثى"
    };

    abstract fun getName(): String
}