package view

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import presentation.MainPresenter

class MainViewTest {

    private val mainPresenter by lazy { MainPresenter() }
    private val mainView by lazy { MainView(mainPresenter)}

    @Test
    fun testFetchUserData() {
        // initial state
        assertNull(mainView.userData)

        // updating the state
        mainView.fetchUserData()

        // check the new state and print it out
        assertEquals("Yomero", mainView.userData?.name)
        mainView.printUserData()
    }
}