![xurxodev logo][xurxodevlogo] 
# Integration Testing for Kotlin multiplatform

This kata is a Kotlin multiplatform version of the kata [KataTODOApiClientKotlin][KataTODOApiClientKotlin] of [Karumi][karumi].

- We are here to practice integration testing using HTTP stubbing. 
- We are going to use [KtorClientMock][ktorclientmock] to return stub responses from a HTTP server.
- We are going to use [KotlinTest][kotlintest] to perform assertions.
- We are going to practice pair programming.

---

## Getting started

This repository contains an kotlin multiplatform library with an API client to interact with a remote service we can use to implement an application.

This API Client is based on one class with name ``TodoApiClient`` containing some methods to interact with the API. Using this class we can get all the tasks we have created before, get a task using the task id, add a new task, update a task or delete an already created task.

The API client has been implemented using a multiplatform networking framework named [Ktor][ktor]. Review the project documentation if needed.

## Tasks

Your task as a multiplatform Kotlin Developer is to **write all the integration tests** needed to check if the API Client is working as expected.

**This repository is ready to build the application, pass the checkstyle using ktlint and your tests in Travis-CI environments.**

My recommendation for this exercise is:

  * Before starting
    1. Fork this repository.
    2. Checkout `integration-testing-kotlin-multiplatform-kata` branch.
    3. Execute the repository playground and make yourself familiar with the code.
    4. Execute `TodoApiClientShould` and watch the only test it contains pass.

  * To help you get started, these are some tests already written at `TodoApiClientShould ` class. Review it carefully before to start writing your own tests. Here you have the description of some tests you can write to start working on this Kata:
	1. Test that the ``Accept`` and ``ContentType`` headers are sent.
    2. Test that the list of ``TaskDto`` instances obtained invoking the getter method of the property ``allTasks``  contains the expected values.
    3. Test that the request is sent to the correct path using the correct HTTP method.
    4. Test that adding a task the body sent to the server is the correct one.

## Considerations

* If you get stuck, `master` branch contains all the tests already solved.

* You will find some utilities to help you test the APIClient easily in:
  ``MockWebServerTest`` and the test resources directory.

## Extra Tasks

If you've covered all the application functionality using integration tests you can continue with some extra tasks: 

* Replace some integration tests we have created with unit tests. A starting point could be the ``DefaultHeadersInterceptor`` class.
* Create your own API client to consume one of the services described in this web: [http://jsonplaceholder.typicode.com/][jsonplaceholder]

---

## Documentation

There are some links which can be useful to finish these tasks:

* [KtorMockClient official documentation][ktorclientmock]
* [Kotlin Test documentation][kotlintest]
* [Ktor documentation][ktor]
* [Test de integración en Kotlin Multiplatform][test-de-integracion-en-kotlin-multiplatform]

# License

Copyright 2019 Jorge Sánchez Fernández

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

[xurxodevlogo]: http://xurxodev.com/content/images/2017/04/xurxodev-readme.png
[ktorclientmock]: https://ktor.io/clients/http-client/testing.html
[kotlintest]: https://kotlinlang.org/api/latest/kotlin.test/index.html
[jsonplaceholder]: http://jsonplaceholder.typicode.com/
[test-de-integracion-en-kotlin-multiplatform]: http://xurxodev.com/test-de-integracion-en-kotlin-multiplatform
[ktor]: https://ktor.io/
[KataTODOApiClientKotlin]: https://github.com/Karumi/KataTODOApiClientKotlin
[karumi]: https://github.com/Karumi
