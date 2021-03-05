# Bootiful Calculator

A challenge submission for the [second Java Discord coding challenge.](https://github.com/Shaunwild97/CodingChallenges/tree/master/bootiful-calculator)

## Usage

This application uses gradle and was developed in Java 15.

You can build and test using:

```shell
./gradlew clean build
```

you can start the application by running:

```shell
./gradlew clean bootRun
```

## About

The app will listen on 1 endpoint, `/calculate`, for a POST request and will return a response based on the operation given.

Example:

```json
POST /calculate
{
  "values": [10, 20, 30],
  "operation": "add",
  "type": "integer"
}
```

will return

```json
HTTP 200
{
  "result": 60
}
```