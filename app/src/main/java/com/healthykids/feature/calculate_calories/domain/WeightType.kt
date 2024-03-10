package com.healthykids.feature.calculate_calories.domain

enum class WeightType {
    None{
        override fun getName() = "غير معروف"
    },
    UnderWeight{
        override fun getName() = "منخفض الوزن"
    },
    NormalWeight{
        override fun getName() = "وزن طبيعي"
    },
    OverWeight{
        override fun getName() = "زائد الوزن"
    },
    Obesity{
        override fun getName() = "سمين"
    };

    abstract fun getName(): String
}