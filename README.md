# Spring Boot Elastic Search Application

This is a simple Spring Boot application that provides (Create, Read ) operations for storing and searchig data i the elastic search.

## Prerequisites

- Java JDK 11 or higher installed
- Maven installed
- Elastic Search Setup


## Elastic Search Setup



## How to Run the Application

1. Clone this repository to your local machine:

```shell
git clone https://github.com/your-username/your-repo.git

cd spring-boot-elasticsearch-demo

mvn clean install

mvn spring-boot:run

The application will start and be accessible at http://localhost:8080.

API Endpoints
# Save a document
curl -X POST -H "Content-Type: application/json" -d '{"title": "Document 1", "content": "This is the content of Document 1."}' http://localhost:8080/documents

# Save another document
curl -X POST -H "Content-Type: application/json" -d '{"title": "Document 2", "content": "This is the content of Document 2."}' http://localhost:8080/documents

# Search for documents
curl -X GET http://localhost:8080/documents/search?q=content
