## Project Report

### Library Management System

#### Overview

This project is a comprehensive **Library Management System** designed to manage books, members, librarians, digital resources, loans, reservations, fines, reviews, categories, and library events. The system provides a robust object-oriented structure, encapsulating real-world library operations and interactions.

---

### Group - 11: Members
| Name                     | Department             |
|--------------------------|------------------------|
| Ceylin Oner              | Statistics             |
| Farid Aljanov            | Statistics             |
| Mehmet Alperen Calıs     | Statistics             |
| Md Mashroor Zilan Snigdho| Mechanical Engineering |

---

#### Objectives

- Efficiently manage library resources (books, digital resources, categories).
- Track member activities, including borrowing, returning, and reserving books.
- Enable librarians to add or remove books and manage library operations.
- Handle fines, reviews, and library events.
- Provide a scalable and maintainable codebase using object-oriented principles.
- Demonstrate all four pillars of OOP: encapsulation, abstraction, inheritance, and polymorphism.

---

#### Key Classes and Their Roles

- **Library**: Central class managing collections of books and members.
- **Book**: Represents a physical book, tracks copies, and supports borrowing/returning.
- **Person**: Abstract base class for people in the system.
- **Member**: Represents a library member, manages borrowed books, and supports borrowing/returning logic.
- **Librarian**: Manages library inventory (add/remove books).
- **LibraryResource**: Abstract base class for resources in the library.
- **DigitalResource**: Represents non-physical resources (e.g., e-books, PDFs).
- **Review**: Allows members to review books and digital resources.
- **Loan**: Tracks the borrowing of books by members.
- **Reservation**: Handles book reservations by members.
- **Fine**: Manages penalties for overdue books.
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

- **Encapsulation**: Private/protected fields with public methods for controlled access.
- **Abstraction**: Abstract classes (`Person`, `LibraryResource`) define common structure and behavior, hiding implementation details.
- **Inheritance**: `Member` and `Librarian` inherit from `Person`; `Book` and `DigitalResource` inherit from `LibraryResource`.
- **Polymorphism**: Method overriding (e.g., `toString()`) allows different classes to provide their own implementations.
- **Exception Handling**: Try-catch-finally blocks to manage errors gracefully.
- **Modularity**: Each class has a clear, single responsibility.
- **Extensibility**: Easy to add new features (e.g., new resource types or operations).


---

#### UML CLass Diagram


The UML Class Diagram can also be accessed from [here](https://drive.google.com/file/d/1RAbndEpugd1JgESrhBtCyeitRTxVfwQu/view?usp=sharing)


![UML CLass Diagram](https://github.com/mzs21/lib-system-demo/blob/main/UML%20Diagram/STAT295%20-%20Group%2011%20-%20UML%20Class%20Diagram%20-%20FINAL.png?raw=true  "UML Class Diagram")

---

#### Usage

The system can be run from the `Main` class, which provides sample data and demonstrates core functionalities such as adding books, registering members, borrowing/returning books, and more. All classes are modular and can be extended for additional features.

---

#### Conclusion

This Library Management System provides a solid foundation for managing a library's resources and operations. The modular, object-oriented design ensures maintainability and scalability for future enhancements. The use of OOP principles ensures the codebase is easy to maintain and extend. The logical grouping of classes allows for clear explanations and smooth collaboration among team members.

---

*For detailed class documentation and usage examples, please refer to the source code files in the repository.*

---

## Steps to run the project

- Clone the repo 

```bash
git clone [url]
```
- replace [url] with the actual url of the repository

Or

- Download the zip file from the repository and extract it to your local machine.
- Open the project folder in VSCode or IntelliJ IDEA
- Open the terminal
- Go to src folder

```bash
cd src
```

- Run the following command to compile the project

```bash
javac *.java
```

- Run the following command to run the project

```bash
java Main
```