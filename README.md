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
    - [Initialization / Termination](#initialization--terminating)
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

### Initialization / Terminating

Before accessing any API endpoint you have to initialize the library with your M3O API token (if you are missing your token, create one [HERE](https://m3o.com/account/keys)):

```kotlin
M3O.initialize("M3O_API_TOKEN")
```

*Tip for Android development*:  
To hide your API token in your app I recommend using the [Hidden Secrets Gradle Plugin](https://github.com/klaxit/hidden-secrets-gradle-plugin).

---

To check if the library is already initialized you can do

```kotlin
M3O.isInitialized()
```

and call

```kotlin
M3O.terminate()
```

to terminate M3O clients and save resources.

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
| 18 | Ethereum | :x: |
| 19 | EV Chargers | :x: |
| 20 | Events | :x: |
| 21 | Files | :white_check_mark: |
| 22 | Forex | :x: |
| 23 | Functions | :white_check_mark: |
| 24 | Geocoding | :x: |
| 25 | GIFs | :x: |
| 26 | Google | :x: |
| 27 | Hello World | :x: |
| 28 | Holidays | :white_check_mark: |
| 29 | ID | :x: |
| 30 | Image | :x: |
| 31 | IP Geolocation | :x: |
| 32 | Jokes | :x: |
| 33 | Lists | :white_check_mark: |
| 34 | Location | :white_check_mark: |
| 35 | Memegen | :white_check_mark: |
| 36 | Minecraft | :x: |
| 37 | Movies | :x: |
| 38 | MQ | :x: |
| 39 | News | :x: |
| 40 | NFTs | :white_check_mark: |
| 41 | Notes | :white_check_mark: |
| 42 | OTP | :x: |
| 43 | Passwords | :x: |
| 44 | Ping | :x: |
| 45 | Places | |
| 46 | Postcode | :x: |
| 47 | Prayer | :x: |
| 48 | Prices | :white_check_mark: |
| 49 | QR Codes | :x: |
| 50 | Quran | :white_check_mark: |
| 51 | Routing | :x: |
| 52 | RSS | :white_check_mark: |
| 53 | Search | :x: |
| 54 | Sentiment | :x: |
| 55 | SMS | :x: |
| 56 | Space | :white_check_mark: |
| 57 | Spam | :x: |
| 58 | Stocks | :x: |
| 59 | Stream | :white_check_mark: |
| 60 | Sunnah | :white_check_mark: |
| 61 | Thumbnail | :x: |
| 62 | Time | :x: |
| 63 | Translate | :x: |
| 64 | Tunnel | :x: |
| 65 | Twitter | :white_check_mark: |
| 66 | URL | :x: |
| 67 | Users | :white_check_mark: |
| 68 | Vehicle | :x: |
| 69 | Wallet | :white_check_mark: |
| 70 | Weather | :x: |
| 71 | Wordle | :x: |
| 72 | YouTube | :white_check_mark: |
