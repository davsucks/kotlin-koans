package i_introduction._7_Nullable_Types

import org.junit.Assert.assertEquals
import org.junit.Test

class N07NullableTypesKtTest {
    private fun testSendMessageToClient(
            client: Client?,
            message: String?,
            shouldBeInvoked: Boolean = false
    ) {
        var invoked = false
        JavaCode7().sendMessageToClient(client, message, object : Mailer {
            override fun sendMessage(email: String, message: String) {
                invoked = true
                assertEquals("The message is not as expected:",
                        message, message)
                assertEquals("The email is not as expected:",
                        email, email)
            }
        })
        assertEquals("The function 'sendMessage' should${if (shouldBeInvoked) "" else "n't"} be invoked",
                shouldBeInvoked, invoked)
    }

    @Test fun everythingIsOk() {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")),
                "Hi Bob! We have an awesome proposition for you...",
                true)
    }

    @Test fun noMessage() {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")), null)
    }

    @Test fun noEmail() {
        testSendMessageToClient(Client(PersonalInfo(null)), "Hi Bob! We have an awesome proposition for you...")
    }

    @Test fun noPersonalInfo() {
        testSendMessageToClient(Client(null), "Hi Bob! We have an awesome proposition for you...")
    }

    @Test fun noClient() {
        testSendMessageToClient(null, "Hi Bob! We have an awesome proposition for you...")
    }
}
