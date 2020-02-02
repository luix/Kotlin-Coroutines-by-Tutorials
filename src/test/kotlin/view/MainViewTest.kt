package view

import contextProvider.CoroutineContextProviderImpl
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import presentation.MainPresenter

class MainViewTest {


    private val testCoroutineDispatcher = TestCoroutineDispatcher()
    private val testCoroutineScope =
            TestCoroutineScope(testCoroutineDispatcher)
    private val testCoroutineContextProvider =
            CoroutineContextProviderImpl(testCoroutineDispatcher)

    private val mainPresenter by lazy { MainPresenter() }
    private val mainView by lazy {
        MainView(
            mainPresenter,
            testCoroutineContextProvider,
            testCoroutineScope
        )
    }

    @Test
    fun testFetchUserData() = testCoroutineScope.runBlockingTest {
        assertNull(mainView.userData)
        mainView.fetchUserData()

        // advance the test clock
        advanceTimeBy(1000)

        assertEquals("Yomero", mainView.userData?.name)
        mainView.printUserData()
    }

    @Test
    fun exampleTest() = runBlockingTest {
        val deferred = async {
            delay(1000)
            async {
                delay(1000)
            }.await()
        }

        deferred.await()    // result available immediately
    }
}