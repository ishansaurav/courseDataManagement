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

### Response

```json
{  
   "moduleA":[  
      "A1",
      "A2",
      "A3"
   ],
   "moduleD":[  
      "D1",
      "D2",
      "D3",
      "D4"
   ],
   "moduleE":[  
      "E1"
   ],
   "moduleC":[  
      "C1",
      "C2"
   ]
}
```

`POST` `http://localhost:8080/enrollStudent/myob/3`

### Response

```json
{  
   "3":[  
      {  
         "myob":{  
            "moduleA":"N",
            "moduleB":"N",
            "moduleC":"N"
         }
      }
   ]
}
```

