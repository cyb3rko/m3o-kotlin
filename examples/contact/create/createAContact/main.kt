package examples.contact.create.createAContact

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import com.cyb3rko.m3okotlin.services.ContactsService

suspend fun main() {
    M3O.initialize("M3O_API_TOKEN")

    try {
        val response = ContactsService.create(
            addresses = listOf(ContactsAddress("company address", "123 street address")),
            birthday = "1995-01-01",
            emails = listOf(
                ContactsEmail("home@example.com", "home"),
                ContactsEmail("work@example.com", "work")
            ),
            links = listOf(ContactsLink("blog", "https://blog.joe.me")),
            name = "Joe",
            note = "this person is very important",
            phones = listOf(
                ContactsPhone("home", "010-12345678"),
                ContactsPhone("work", "010-87654321")
            ),
            socialMedias = listOf(
                ContactsSocialMedia("twitter", "joe-twitter"),
                ContactsSocialMedia("facebook", "joe-facebook")
            )
        )
        println(response)
    } catch (e: Exception) {
        println(e)
    }
}
