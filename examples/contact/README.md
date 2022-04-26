# Contact

An [m3o.com](https://m3o.com) API. For example usage see [m3o.com/contact/api](https://m3o.com/contact/api).

Endpoints:

## Create

Create a contact


[https://m3o.com/contact/api#Create](https://m3o.com/contact/api#Create)

```kotlin
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
```
## Update

Update a contact


[https://m3o.com/contact/api#Update](https://m3o.com/contact/api#Update)

```kotlin

```
## Read

Read contact details


[https://m3o.com/contact/api#Read](https://m3o.com/contact/api#Read)

```kotlin

```
## Delete

Delete a contact


[https://m3o.com/contact/api#Delete](https://m3o.com/contact/api#Delete)

```kotlin

```
## List

List contacts


[https://m3o.com/contact/api#List](https://m3o.com/contact/api#List)

```kotlin

```
## List

List contacts


[https://m3o.com/contact/api#List](https://m3o.com/contact/api#List)

```kotlin

```