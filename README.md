# Notes Sharing REST API

## Overview

The Notes Sharing REST API is a scalable Spring Boot REST API service designed for creating, reading, updating, deleting, and sharing notes in various formats, including PDFs, videos, and web links. This API supports comprehensive CRUD operations and advanced search functionality by title, department, field, or owner.

## Key Features

- **CRUD Operations:** Create, read, update, and delete notes.
- **Format Support:** Share notes in PDF, video, and web link formats using url.
- **Advanced Search:** Search notes by title, department, field, or owner.
- **Scalable Architecture:** Designed for scalability and performance.

## Technologies Used

- **Spring Boot:** Framework for building the REST API.
- **Java:** Primary programming language.
- **MySQL:** Database for storing notes.
- **JPA/Hibernate:** ORM for database operations.

## API Endpoints

### Notes

- **Get All Notes**
    ```http
    GET /api/notes/all
    ```

- **Get Note by ID**
    ```http
    GET /api/notes/id/{id}
    ```
- **Get Note by Department**
    ```http
    GET /api/notes/department/{department}
    ```
- **Get Note by Owner**
    ```http
    GET /api/notes/owner/{owner}
    ```
- **Get Note by Title**
    ```http
    GET /api/notes/title/{title}
    ```
- **Get Note by Field**
    ```http
    GET /api/notes/field/{field}
    ```

- **Create Note**
    ```http
    POST /api/notes/add
    ```
    Request Body:
    ```json
    {
      "title": "Sample Note",
      "contentUrl": "This is a sample note.",
      "contentType": "PDF",
      "owner": "John Doe",
      "department": "Engineering",
      "field": "Software Development"
    }
    ```

- **Update Note**
    ```http
    PUT /api/notes/update/{id}
    ```
    Request Body (update fields as needed):
    ```json
    {
      "id":1,
      "title": "Updated Note Title",
      "contentUrl": "This is updated sample note.",
      "contentType": "PDF",
      "owner": "Jane Doe",
      "department": "IT",
      "field": "Data Science"
    }
    ```

- **Delete Note**
    ```http
    DELETE /api/notes/delete/{id}
    ```
## Contact Information

- **Developer**: Shiv Prakash Verma
- **Email**: shivprakashlps@gmail.com
- **College**: IIT Ropar
