package reachip

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope

interface Randomizer {
    /**
     * Return random value as string
     */
    fun getAsString(): String

    /**
     * Décrit un Bean ayant le comportement "singleton".
     */
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    fun getAsStringSingletonScope(): String = getAsString()

    /**
     * Décrit un Bean ayant le comportement "prototype".
     */
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    fun getAsStringPrototypeScope(): String = getAsString()
}
