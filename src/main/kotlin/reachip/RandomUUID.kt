package reachip

class RandomUUID : Randomizer {
    override fun getAsString(): String = java.util.UUID.randomUUID().toString()
}
