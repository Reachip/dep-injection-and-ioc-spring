package reachip

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

internal class SysOutServiceTest {
    @Bean
    @Primary
    fun randomUUIDBean(): Randomizer {
        return RandomUUID();
    }

    @Bean
    fun randomNumber(): Randomizer {
        return RandomNumber();
    }

    @Bean
    fun sysOutRunnableBean(randomizer: Randomizer): Runnable {
        return SysOutService(randomizer);
    }

    @Test
    fun runTest() {
        // On définit le contexte du programme. Ici, notre simple classe qui génère des UUID
        val appCtx = AnnotationConfigApplicationContext(SysOutServiceTest::class.java)

        // On récupère le premier runnable
        val runnable: Runnable = appCtx.getBean(Runnable::class.java);

        assertTrue((runnable as SysOutService).randomizer is RandomUUID)

        // On lance la méthode run()
        assertDoesNotThrow("Should not throw exception") { runnable.run() }
    }
}
