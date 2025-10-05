package com.anywhere.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}