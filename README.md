
# ![integration-testing-kotlin-multiplatform](https://user-images.githubusercontent.com/5593590/62697749-b78da300-b9db-11e9-92e4-329ce3d39bd9.png)

[![Build Status](https://travis-ci.org/xurxodev/integration-testing-kotlin-multiplatform-kata.svg?branch=master)](https://travis-ci.org/xurxodev/integration-testing-kotlin-multiplatform-kata) [![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin#examples-back-)

![](http://xurxodev.com/content/images/2019/02/Kotlin-multiplatform-library.png)

This kata is a Kotlin multiplatform version of the kata [KataTODOApiClientKotlin][KataTODOApiClientKotlin] of [Karumi][karumi].

- We are here to practice integration testing using HTTP stubbing. 
- We are going to use [KtorClientMock][ktorclientmock] to return stub responses.
- We are going to use [KotlinTest][kotlintest] to write tests and to perform assertions.
- We are going to practice pair programming.

---

## Getting started

This repository contains an kotlin multiplatform library with an API client to interact with the [JSONPlaceholder service](http://jsonplaceholder.typicode.com).

This API Client is based on one class with name ``TodoApiClient`` containing some methods to interact with the API. Using this class we can get all the tasks, get a task using the task id, add a new task, update a task or delete an already created task.

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
	1. Test that the ``Accept`` headers are sent.
    2. Test that the list of ``Task`` instances obtained invoking the getter method of the property ``allTasks``  contains the expected values.
    3. Test that the request is sent to the correct path using the correct HTTP method.
    4. Test that adding a task the body sent to the server is the correct one.

## Considerations

* If you get stuck, `master` branch contains all the tests already solved.

* You will find some utilities to help you test the APIClient easily in:
  ``TodoApiMockEngine`` and the common/responses directory in commonTest source set.

## Extra Tasks

If you've covered all the application functionality using integration tests you can continue with some extra tasks: 

* Create your own API client to consume one of the services described in this web: [http://jsonplaceholder.typicode.com/][jsonplaceholder]

---

## Documentation

There are some links which can be useful to finish these tasks:

* [KtorMockClient official documentation][ktorclientmock]
* [Kotlin Test documentation][kotlintest]
* [Ktor documentation][ktor]
* [How to create a REST API client and its integration tests in Kotlin Multiplatform][how-to-create-a-rest-api-client-and-its-integration-tests-in-kotlin-multiplatform] (English version)
* [Cómo crear un cliente API REST y sus tests de integración en Kotlin Multiplatform][cliente-api-rest-y-test-de-integracion-en-kotlin-multiplatform] (Spanish version)

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
[cliente-api-rest-y-test-de-integracion-en-kotlin-multiplatform]: http://xurxodev.com/cliente-api-rest-y-test-de-integracion-en-kotlin-multiplatform
[how-to-create-a-rest-api-client-and-its-integration-tests-in-kotlin-multiplatform]: https://medium.com/@xurxodev/how-to-create-a-rest-api-client-and-its-integration-tests-in-kotlin-multiplatform-d76c9a1be348
[ktor]: https://ktor.io/
[KataTODOApiClientKotlin]: https://github.com/Karumi/KataTODOApiClientKotlin
[karumi]: https://github.com/Karumi
