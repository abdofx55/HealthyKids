package com.healthykids.feature.calculate_calories.domain

enum class Age {
    Six{
        override fun getName() = "6"
    },
    Seven{
        override fun getName() = "7"
    },
    Eight{
        override fun getName() = "8"
    },
    Nine{
        override fun getName() = "9"
    },
    Ten{
        override fun getName() = "10"
    },
    Eleven{
        override fun getName() = "11"
    },
    Twelve{
        override fun getName() = "12"
    };

    abstract fun getName(): String
}