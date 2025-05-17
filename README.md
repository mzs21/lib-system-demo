## This repo is for playing around.

## Project Report

### Library Management System

#### Overview

This project is a comprehensive **Library Management System** designed to manage books, members, librarians, digital resources, loans, reservations, fines, reviews, and library events. The system provides a robust object-oriented structure, encapsulating real-world library operations and interactions.

---

#### Objectives

- Efficiently manage library resources (books, digital resources, categories).
- Track member activities, including borrowing, returning, and reserving books.
- Enable librarians to add or remove books and manage library operations.
- Handle fines, reviews, and library events.
- Provide a scalable and maintainable codebase using object-oriented principles.

---

#### Key Classes and Their Roles

- **Book**: Represents a physical book, tracks copies, and supports borrowing/returning.
- **Member**: Represents a library member, manages borrowed books, and supports borrowing/returning logic.
- **Librarian**: Manages library inventory (add/remove books).
- **Library**: Central class managing collections of books and members.
- **Category**: Classifies books and digital resources.
- **DigitalResource**: Represents non-physical resources (e.g., e-books, PDFs).
- **Loan**: Tracks the borrowing of books by members.
- **Reservation**: Handles book reservations by members.
- **Fine**: Manages penalties for overdue books.
- **Review**: Allows members to review books.
- **LibraryEvent**: Represents events organized by the library.

---

#### Features

- **Book Management**: Add, remove, borrow, return, and review books.
- **Member Management**: Register members, track borrowed books, and manage fines.
- **Librarian Operations**: Add or remove books from the library.
- **Digital Resource Access**: Manage and access digital resources.
- **Loan and Reservation Tracking**: Monitor which books are loaned or reserved.
- **Event Management**: Organize and track library events.
- **Error Handling**: Robust exception handling for invalid operations.

---

#### Design Principles

- **Encapsulation**: Private fields with public methods for controlled access.
- **Exception Handling**: Try-catch-finally blocks to manage errors gracefully.
- **Modularity**: Each class has a clear, single responsibility.
- **Extensibility**: Easy to add new features (e.g., new resource types or operations).

---

#### Usage

The system can be run from the `Main` class, which provides sample data and demonstrates core functionalities such as adding books, registering members, borrowing/returning books, and more.

---

#### Conclusion

This Library Management System provides a solid foundation for managing a library's resources and operations. The modular, object-oriented design ensures maintainability and scalability for future enhancements.

---

*For detailed class documentation and usage examples, please refer to the source code files in the repository.*

---

## Steps to run the project

- Clone the repo

```bash
git clone
```

- Open the project in VSCode or IntelliJ IDEA
- Open the terminal
- Go to src folder
- Run the following command to compile the project

```bash
javac *.java
```

- Run the following command to run the project

```bash
java Main
```