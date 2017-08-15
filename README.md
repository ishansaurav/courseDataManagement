# Course Data Management

## Requirements

- Java
- Maven

## Setup

```bash
mvn clean package
```

## Usage

```bash
mvn spring-boot:run
```

### Request

`POST` `http://localhost:8080/getCourse/xero`

`POST` `http://localhost:8080/enrollStudent/myob/3`


### Response

```json
{
    "generalizedText": "ORGANIZATION is awesome"
}
```
