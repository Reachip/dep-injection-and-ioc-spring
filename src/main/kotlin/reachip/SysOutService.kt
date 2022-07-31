package reachip

class SysOutService(val randomizer: Randomizer) : Runnable {
    override fun run() = println(randomizer.getAsString())
}
