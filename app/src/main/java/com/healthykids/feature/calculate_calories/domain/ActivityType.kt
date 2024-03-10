package com.healthykids.feature.calculate_calories.domain

    enum class ActivityType {
        Low{
            override fun getName() = "منخفض"
        },
        High{
            override fun getName() = "عالي"
        };

        abstract fun getName(): String
    }