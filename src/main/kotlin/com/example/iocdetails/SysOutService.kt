package com.example.iocdetails

class SysOutService(val randomizer: Randomizer) : Runnable {
    override fun run() = println(randomizer.getAsString())
}
