# generationbrasil-democliente
Challenge proposed for the students I follow as a mentor at Generation Brasil.

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/downloads/#java11)
- [Maven 3](https://maven.apache.org)
- H2 Database
- JPA + Hibernate

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.generation.brasil.demo.DemoApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Success Requests examples

**GET ../v1/clientes**

*Response:*
```shell
StatusCode: 200
```
```json
[
    {
        "id": 1,
        "nome": "Dodo",
        "cnpj": "27702708000140",
        "enderecos": [
            {
                "id": 1,
                "rua": "palmeira do mar, 19",
                "bairro": "parque das arvores",
                "cidade": "são paulo",
                "estado": "sp",
                "complemento": "casa"
            }
        ],
        "projetos": [
            {
                "id": 1,
                "nome": "generation brasil",
                "codigo": "123456",
                "valor": 100.00
            }
        ]
    }
]
```
----------
**GET ../v1/clientes/{id}**

*Response:*
```shell
StatusCode: 200
```
```json
{
    "id": 1,
    "nome": "Dodo",
    "cnpj": "27702708000140",
    "enderecos": [
        {
            "id": 1,
            "rua": "palmeira do mar, 19",
            "bairro": "parque das arvores",
            "cidade": "são paulo",
            "estado": "sp",
            "complemento": "casa"
        }
    ],
    "projetos": [
        {
            "id": 1,
            "nome": "generation brasil",
            "codigo": "123456",
            "valor": 100.00
        }
    ]
}
```
---------
**POST ../v1/clientes**

*Request:*
```json
{
    "nome": "Dodo",
    "cnpj": "27702708000140",
    "enderecos": [
        {
            "rua": "palmeira do mar, 19",
            "bairro": "parque das arvores",
            "cidade": "são paulo",
            "estado": "sp",
            "complemento": "casa"
        }
    ],
    "projetos": [
        {
            "nome": "generation brasil",
            "codigo": "123456",
            "valor": 100
        }
    ]
}
```

*Response:*
```shell
StatusCode: 200
```
```json
{
    "id": 1,
    "nome": "Dodo",
    "cnpj": "27702708000140",
    "enderecos": [
        {
            "id": 1,
            "rua": "palmeira do mar, 19",
            "bairro": "parque das arvores",
            "cidade": "são paulo",
            "estado": "sp",
            "complemento": "casa"
        }
    ],
    "projetos": [
        {
            "id": 1,
            "nome": "generation brasil",
            "codigo": "123456",
            "valor": 100.00
        }
    ]
}
```
-----------
**PUT ../v1/clientes/{id}**

*Request:*
```json
{
    "id": 1,
    "nome": "Paloma",
    "cnpj": "27702708000140",
    "enderecos": [
        {
            "id": 1,
            "rua": "palmeira do mar, 20",
            "bairro": "parque das arvores",
            "cidade": "são paulo",
            "estado": "sp",
            "complemento": "casa"
        }
    ],
    "projetos": [
        {
            "id": 1,
            "nome": "generation brasil",
            "codigo": "123456",
            "valor": 100
        },
        {
            "id": 2,
            "nome": "Matematica ONG",
            "codigo": "1234567890",
            "valor": 1000
        }
    ]
}
```

*Response:*
```shell
StatusCode: 200
```
```json
{
    "id": 1,
    "nome": "Paloma",
    "cnpj": "27702708000140",
    "enderecos": [
        {
            "id": 1,
            "rua": "palmeira do mar, 20",
            "bairro": "parque das arvores",
            "cidade": "são paulo",
            "estado": "sp",
            "complemento": "casa"
        }
    ],
    "projetos": [
        {
            "id": 1,
            "nome": "generation brasil",
            "codigo": "123456",
            "valor": 100
        },
        {
            "id": 2,
            "nome": "Matematica ONG",
            "codigo": "1234567890",
            "valor": 1000
        }
    ]
}
```
-----------
**DELETE ../v1/clientes/{id}**
*Response:*
```shell
StatusCode: 200
```
## Warning Requests examples ##

**ClienteNotFoundException**

*Response:*
```shell
StatusCode: 404
```
```json
{
    "message": "Não foi possivel encontrar o cliente",
    "statusCode": 404
}
```

