package com.example.aigenerator.model

import java.time.LocalDate

sealed class Subscription {

    abstract val isActive: Boolean

    data object NoSubscription : Subscription() {
        override val isActive: Boolean get() = false
    }

    data class FreeTrial(val startDate: LocalDate) : Subscription() {
        val endDate: LocalDate = startDate.plusDays(3)
        val daysLeft: Int get() = (endDate.toEpochDay() - LocalDate.now().toEpochDay()).toInt()
        override val isActive: Boolean get() = LocalDate.now().isBefore(endDate)
    }

    data class Monthly(val startDate: LocalDate) : Subscription() {
        val endDate: LocalDate get() = startDate.plusMonths(1)
        override val isActive: Boolean get() = LocalDate.now().isBefore(endDate)
    }

    data class Annual(val startDate: LocalDate) : Subscription() {
        val endDate: LocalDate get() = startDate.plusYears(1)
        override val isActive: Boolean get() = LocalDate.now().isBefore(endDate)
    }
}