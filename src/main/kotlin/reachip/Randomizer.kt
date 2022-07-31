package reachip

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope

interface Randomizer {
    fun getAsString(): String

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    fun getAsStringSingletonScope(): String = getAsString()

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    fun getAsStringPrototypeScope(): String = getAsString()
}
