<div align="center">
    <p>
        <img src="https://discordapp.com/api/guilds/861917584437805127/widget.png?style=banner2" alt="Discord Banner"/>
    </p>
</div>

---

# M3O Kotlin (JVM) Client

This is the handcrafted Kotlin client to access APIs on the M3O Platform.

- [What is M3O](#what-is-m3o)
- [Usage](#usage)
    - [Import](#import)
    - [Initializing](#initializing)
    - [Calling Endpoints](#calling-endpoints)
    - [Examples](#examples)
- [Extension Functions](#extension-functions)
- [Supported APIs](#supported-apis)

## What is M3O

M3O ([website](https://m3o.com/), [github repo](https://github.com/m3o/m3o)) is an attempt to build a new public cloud platform with higher level building blocks for the Next generation of developers. M3O is powered by the open source [Micro](https://github.com/micro/micro) platform and programmable real world [Micro Services](https://github.com/micro/services).

M3O APIs include DB, Cache, Stream, MQ, Events, Functions, App, SMS and more.

## Usage

:warning: This Kotlin client is currently in the beta phase and may experience major and breaking changes.  
Therefore I don't recommend to use this client in production at the moment.

### Import

To use this library you first have to manually download the `.jar` file via the [Packages tab](https://github.com/cyb3rko/m3o-kotlin/packages/1385804).  
Then import it into your project.

Additionally this client depends on the following dependencies, which you have to import for this library to work properly:

```gradle
implementation 'io.ktor:ktor-client-core:1.6.8'
implementation 'io.ktor:ktor-client-serialization:1.6.8'
implementation 'org.java-websocket:Java-WebSocket:1.5.3'
implementation 'org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2'
```

The built-in Ktor library needs an [Ktor HTTP Client](https://ktor.io/docs/http-client-engines.html). For example

```gradle
implementation 'io.ktor:ktor-client-apache:1.6.8'
```

or

```gradle
implementation 'io.ktor:ktor-client-android:1.6.8'
```

### Initializing

Before accessing any API endpoint you have to initialize the library with your M3O API token (if you are missing your token, create one [HERE](https://m3o.com/account/keys)):

```kotlin
M3O.initialize("M3O_API_TOKEN")
```

*Tip for Android development*:  
To hide your API token in your app I recommend using the [Hidden Secrets Gradle Plugin](https://github.com/klaxit/hidden-secrets-gradle-plugin).

### Calling endpoints

Every endpoint (which has been added to this Kotlin client) has it's own service object, for example `HelloWorldService`.

To make any API requests now just call the endpoints via methods on the service object, for example `HelloWorldService.call("John")`.

### Examples

Find the `examples` directory [HERE](https://github.com/cyb3rko/m3o-kotlin/tree/main/examples) for examples besides the following HelloWorld example.

---

[Hello World](https://m3o.com/helloworld) Call Example:

```kotlin
import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.services.HelloWorldService

suspend fun main() {
    M3O.initialize("M3O_API_TOKEN")

    try {
        val response = HelloWorldService.call("John")
        println(response)
    } catch (e: Exception) {
        println(e)
    }
}
```

[Hello World](https://m3o.com/helloworld) Stream Example:

```kotlin
import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.services.HelloWorldService

fun main() {
    M3O.initialize("M3O_API_TOKEN")

    try {
        val socket = HelloWorldService.stream("John", 10) { socketError, response ->
            if (socketError == null) {
                println(response)
            } else {
                println(socketError)
            }
        }
    } catch (e: Exception) {
        println(e)
    }
}
```

## Extension Functions

In addition to calling methods on the service objects there are extension functions for some of the many data classes.  
They simplify method calls by calling API functions on data classes.

Check for their availability in the [table below](#supported-apis).

---

**Example**:  
Log a user in and out again (without extension function)

```kotlin
val mySession = UsersService.login("myPassword", "myEmail").session
UsersService.logout(mySession.id)
```

(with extension function)

```kotlin
val mySession = UsersService.login("myPassword", "myEmail").session
mySession.logout()       <-- extension function
```

---

**Another Example**:  
Join a chat room and leave again (without extension function)

```kotlin
val userID = "1234"
val chatRoom = ChatService.list(userID).rooms[0]
ChatService.join(chatRoom.id, userID) { error, response ->
    println(response)
}
ChatService.leave(chatRoom.id, userID)
```

(with extension function)

```kotlin
val userID = "1234"
val chatRoom = ChatService.list(userID).rooms[0]
chatRoom.join(userID) { error, response ->        <-- extension function
    println(response)
}
chatRoom.leave(userID)       <-- extension function
```

## Supported APIs

Below all supported APIs:

| ID | Service | [Extension Functions](#extension-functions) |
|---|---|---|
| 1 | Address | :x: |
| 2 | Analytics | :white_check_mark: |
| 3 | Answers | :x: |
| 4 | Apps | :white_check_mark: |
| 5 | Avatar | :x: |
| 6 | Bitcoin | :x: |
| 7 | Cache | :x: |
| 8 | Carbon | :x: |
| 9 | Chat | :white_check_mark: |
| 10 | Comments | :white_check_mark: |
| 11 | Contacts | :white_check_mark: |
| 12 | Crypto | :white_check_mark: |
| 13 | Currency | :white_check_mark: |
| 14 | DB | :x: |
| 15 | DNS | :x: |
| 16 | Email | :x: |
| 17 | Emoji | :x: |
| 18 | EV Chargers | :x: |
| 19 | Events | :x: |
| 20 | Files | :white_check_mark: |
| 21 | Forex | :x: |
| 22 | Functions | :white_check_mark: |
| 23 | Geocoding | :x: |
| 24 | GIFs | :x: |
| 25 | Google | :x: |
| 26 | Hello World | :x: |
| 27 | Holidays | :white_check_mark: |
| 28 | ID | :x: |
| 29 | Image | :x: |
| 30 | IP Geolocation | :x: |
| 31 | Jokes | :x: |
| 32 | Lists | :white_check_mark: |
| 33 | Location | :white_check_mark: |
| 34 | Memegen | :white_check_mark: |
| 35 | Minecraft | :x: |
| 36 | Movies | :x: |
| 37 | MQ | :x: |
| 38 | News | :x: |
| 39 | NFTs | :white_check_mark: |
| 40 | Notes | :white_check_mark: |
| 41 | OTP | :x: |
| 42 | Passwords | :x: |
| 43 | Ping | :x: |
| 44 | Places |  |
| 45 | Postcode | :x: |
| 46 | Prayer | :x: |
| 47 | Prices | :white_check_mark: |
| 48 | QR Codes | :x: |
| 49 | Quran | :white_check_mark: |
| 50 | Routing | :x: |
| 51 | RSS | :white_check_mark: |
| 52 | Search | :x: |
| 53 | Sentiment | :x: |
| 54 | SMS | :x: |
| 55 | Space | :white_check_mark: |
| 56 | Spam | :x: |
| 57 | Stocks | :x: |
| 58 | Stream | :white_check_mark: |
| 59 | Sunnah | :white_check_mark: |
| 60 | Thumbnail | :x: |
| 61 | Time | :x: |
| 62 | Translate | :x: |
| 63 | Tunnel | :x: |
| 64 | Twitter | :white_check_mark: |
| 65 | URLs | :x: |
| 66 | Users | :white_check_mark: |
| 67 | Vehicle | :x: |
| 68 | Weather | :x: |
| 69 | YouTube | :white_check_mark: |