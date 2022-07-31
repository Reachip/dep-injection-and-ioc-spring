package reachip

import kotlin.random.Random

class RandomNumber : Randomizer {
    override fun getAsString(): String = Random.nextInt(0, 100).toString()
}
