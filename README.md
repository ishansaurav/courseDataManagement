# Generalizer Proof-of-Concept

## Requirements

- Java
- Maven

## Setup

```bash
mvn package
```

## Usage

```bash
mvn spring-boot:run
```

### Request

`POST` `http://localhost:8080/generalize`

```json
{
    "text":"McDonalds is awesome"
}
```

### Response

```json
{
    "generalizedText": "ORGANIZATION is awesome"
}
```
