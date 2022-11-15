# Project Spring Boot Purchase REST API

This is a projetc Java (11)/ Maven / Spring Boot (version 2.7.5) application that can be used for purchasing products

## How to Run

This application is packaged as a jar which has Tomcat embedded. No Tomcat installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository
* Make sure you are using JDK 11 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by of method:
```
	java -jar target/purchase-0.0.1.jar
```

Once the application runs you should see something like this

```
2022-11-14 20:29:55.176  INFO 16856 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-11-14 20:29:55.194  INFO 16856 --- [           main] com.nuvy.purchase.PurchaseApplication    : Started PurchaseApplication in 4.141 seconds (JVM running for 4.845)
```

## About the Service

The service is a register purchase to product and calculate selic tax if necessary.

Here is what this application demonstrates:

### Register a purchase to product

```
http://localhost:8080/purchase/product

Request:
--data-raw '{
    "product": {
        "id": 123,
        "name": "Aluminio XPTO",
        "price": 10000.00
    },
    "payment": {
        "entry": 10000.00,
        "installments": 2
    }
}'

Response: HTTP 201 Created
Content: 
{
    "installments": [
        {
            "installmentsNum": 1,
            "price": 5000.00,
            "tax": 0
        },
        {
            "installmentsNum": 2,
            "price": 5000.00,
            "tax": 0
        }
    ]
}
```

### To view Swagger Open API docs

Run the server and browse to http://localhost:8080/swagger-ui.html

# Questions and Comments: allan.tavares@msn.com

