package reachip

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

internal class SysOutServiceTest {
    @Bean
    fun randomUUIDBean(): Randomizer {
        return RandomUUID();
    }

    @Bean
    @Primary
    fun randomNumber(): Randomizer {
        return RandomNumber();
    }

    @Bean
    fun sysOutRunnableBeanWithRandomUUID(randomizer: Randomizer): Runnable {
        return SysOutService(randomizer);
    }

    @Test
    fun runTest() {
        // On définit le contexte du programme. Ici, notre simple classe qui génère des UUID
        val appCtx = AnnotationConfigApplicationContext(SysOutServiceTest::class.java)

        // On récupère le premier runnable
        val runnable: Runnable = appCtx.getBean(Runnable::class.java);

        assertTrue((runnable as SysOutService).randomizer is RandomNumber)

        // On lance la méthode run()
        assertDoesNotThrow("Should not throw exception") { runnable.run() }
    }
}
