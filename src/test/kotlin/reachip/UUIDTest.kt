package reachip

import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.context.annotation.AnnotationConfigApplicationContext

internal class RandomUUIDScopeTest {
    @Test
    fun getAsStringSingletonScopeTest() {
        // On définit le contexte du programme. Ici, notre simple classe qui génère des UUID
        val appCtx = AnnotationConfigApplicationContext(RandomUUID::class.java)

        // On récupère le retour de la méthode getAsString() de notre classe
        // via la méthode getBean. On s'assure de ce fait qu'on récupère une
        // seule fois le retour de la méthode.
        val uuidAsString = appCtx.getBean("getAsStringSingletonScope")


        // On fait deux fois un getBean sur la méthode, on constate que le retour reste le même alors que la méthode
        // doit forcèment retourner un seul et unique UUID à chaque fois.
        for (loop in 0..1) {
            val nextUUIDGenerated = appCtx.getBean("getAsStringSingletonScope")
            assertTrue(uuidAsString == nextUUIDGenerated)
        }

        // Un bean correspond à une dépendance optimisée à des fins d'optimisation de la mémoire
        // via le pattern singleton.
    }

    @Test
    fun getAsStringPrototypeScopeTest() {
        // On définit le contexte du programme. Ici, notre simple classe qui génère des UUID
        val appCtx = AnnotationConfigApplicationContext(RandomUUID::class.java)

        // On récupère le retour de la méthode getAsString() de notre classe
        // via la méthode getBean. On s'assure de ce fait qu'on récupère une
        // seule fois le retour de la méthode.
        val uuidAsString = appCtx.getBean("getAsStringPrototypeScope")


        // On fait deux fois un getBean sur la méthode, on constate que le retour reste le même alors que la méthode
        // doit forcèment retourner un seul et unique UUID à chaque fois.
        for (loop in 0..1) {
            val nextUUIDGenerated = appCtx.getBean("getAsStringPrototypeScope")
            assertFalse(uuidAsString == nextUUIDGenerated)
        }

        // Un bean correspond à une dépendance optimisée à des fins d'optimisation de la mémoire
        // via le pattern singleton.
    }
}


internal class RandomUUIDBeanInjectionTest {
    @Test
    fun test() {
        assertTrue(true)
    }
}
