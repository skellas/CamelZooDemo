Camel Zoo Demo Project
=========================

To build this project use

    mvn install

To run this project from within Maven use

    mvn exec:java

For more help see the Apache Camel documentation

    http://camel.apache.org/


=========================
 - Get no Animals:
GET localhost:8080/get
RESPONSE:
    []

 - Create Some Animals:
GET localhost:8080/create/dog/Doug
RESPONSE:
    {
        "@class": "Dog",
        "name": "Doug",
        "id": 1,
        "type": "DOG",
        "habitat": "SUBURBIA"
    }
GET localhost:8080/create/lion/Leo
RESPONSE:
    {
        "@class": "Lion",
        "name": "Leo",
        "id": 2,
        "type": "LION",
        "habitat": "SAFARI"
    }
GET localhost:8080/create/camel/Clarice
RESPONSE:
    {
        "@class": "Camel",
        "name": "Clarice",
        "id": 3,
        "type": "CAMEL",
        "habitat": "DESERT"
    }

 - Get all Animals
GET localhost:8080/get
RESPONSE:
    [{
        "@class": "Dog",
        "name": "Doug",
        "id": 1,
        "type": "DOG",
        "habitat": "SUBURBIA"
    }, {
        "@class": "Lion",
        "name": "Leo",
        "id": 2,
        "type": "LION",
        "habitat": "SAFARI"
    }, {
        "@class": "Camel",
        "name": "Clarice",
        "id": 3,
        "type": "CAMEL",
        "habitat": "DESERT"
    }]
 - Update Leo's Habitat:
POST localhost:8080/update/2
{
    "@class": "Lion",
    "name": "Leo",
    "id": 2,
    "type": "LION",
    "habitat": "Aquarium"
}
RESPONSE:
    {
        "@class": "Lion",
        "name": "Leo",
        "id": 2,
        "type": "LION",
        "habitat": "AQUARIUM"
    }

 - Get all Animals
GET localhost:8080/get
RESPONSE:
    [{
        "@class": "Dog",
        "name": "Doug",
        "id": 1,
        "type": "DOG",
        "habitat": "SUBURBIA"
    }, {
        "@class": "Lion",
        "name": "Leo",
        "id": 2,
        "type": "LION",
        "habitat": "AQUARIUM"
    }, {
        "@class": "Camel",
        "name": "Clarice",
        "id": 3,
        "type": "CAMEL",
        "habitat": "DESERT"
    }]
 - Delete Doug
DELETE localhost:8080/delete/1
RESPONSE:
    [{
        "@class": "Lion",
        "name": "Leo",
        "id": 2,
        "type": "LION",
        "habitat": "AQUARIUM"
    }, {
        "@class": "Camel",
        "name": "Clarice",
        "id": 3,
        "type": "CAMEL",
        "habitat": "DESERT"
    }]
