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

## What is M3O

[M3O](https://m3o.com/) is an attempt to build a new public cloud platform with higher level building blocks for the Next generation of developers. M3O is powered by the open source [Micro](https://github.com/micro/micro) platform and programmable real world [Micro Services](https://github.com/micro/services).

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