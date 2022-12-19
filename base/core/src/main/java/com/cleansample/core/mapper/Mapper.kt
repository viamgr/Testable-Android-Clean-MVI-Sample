package com.cleansample.core.mapper

interface Mapper<E, D> {
    fun map(type: E): D
}
