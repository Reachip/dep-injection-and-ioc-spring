package com.example.iocdetails

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope

class RandomUUID : Randomizer {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    fun getAsStringSingletonScope(): String = getAsString()

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    fun getAsStringPrototypeScope(): String = getAsString()

    override fun getAsString(): String = java.util.UUID.randomUUID().toString()
}
