package reachip

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope

class RandomUUID : Randomizer {
    override fun getAsString(): String = java.util.UUID.randomUUID().toString()
}
