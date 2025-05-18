import java.util.*;

public class Main {
    private static Library library = new Library();
    private static Librarian librarian = new Librarian(1, "Admin Librarian");
    private static Scanner scanner = new Scanner(System.in);

    // For simulation purposes
    private static List<DigitalResource> digitalResources = new ArrayList<>();
    private static List<Review> reviews = new ArrayList<>();
    private static List<Loan> loans = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();
    private static List<Fine> fines = new ArrayList<>();
    private static List<LibraryEvent> events = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();

    public static void main(String[] args) {
        initializeSampleData();

        boolean running = true;
        while (running) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Add Member");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. List All Books");
            System.out.println("7. List All Members");
            System.out.println("8. Add Digital Resource");
            System.out.println("9. List Digital Resources");
            System.out.println("10. Add Review");
            System.out.println("11. List Reviews");
            System.out.println("12. Make Reservation");
            System.out.println("13. List Reservations");
            System.out.println("14. Pay Fine");
            System.out.println("15. List Fines");
            System.out.println("16. Add Library Event");
            System.out.println("17. List Library Events");
            System.out.println("18. Add Category");
            System.out.println("19. List Categories");
            System.out.println("20. Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();
            try {
                switch (choice) {
                    case 1: addBook(); break;
                    case 2: removeBook(); break;
                    case 3: addMember(); break;
                    case 4: borrowBook(); break;
                    case 5: returnBook(); break;
                    case 6: listAllBooks(); break;
                    case 7: listAllMembers(); break;
                    case 8: addDigitalResource(); break;
                    case 9: listDigitalResources(); break;
                    case 10: addReview(); break;
                    case 11: listReviews(); break;
                    case 12: makeReservation(); break;
                    case 13: listReservations(); break;
                    case 14: payFine(); break;
                    case 15: listFines(); break;
                    case 16: addLibraryEvent(); break;
                    case 17: listLibraryEvents(); break;
                    case 18: addCategory(); break;
                    case 19: listCategories(); break;
                    case 20:
                        running = false;
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Oops! " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    private static void initializeSampleData() {
        categories.add(new Category(1, "Classic", "Classic literature"));
        categories.add(new Category(2, "Fiction", "Fictional works"));
        categories.add(new Category(3, "Dystopian", "Dystopian novels"));

        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925, 3));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", 1960, 2));
        library.addBook(new Book(3, "1984", "George Orwell", "Dystopian", 1949, 1));
        library.addMember(new Member(1, "John Doe", "john@example.com"));
        library.addMember(new Member(2, "Jane Smith", "jane@example.com"));

        digitalResources.add(new DigitalResource(1, "Digital Math Book", "Prof. Euler", "PDF", "http://math.com/book.pdf"));
        digitalResources.add(new DigitalResource(2, "History Documentary", "Dr. Smith", "Video", "http://history.com/doc.mp4"));

        events.add(new LibraryEvent(1, "Book Fair", "Annual book fair event", java.time.LocalDate.now().plusDays(10)));
    }

    private static void addBook() {
        System.out.println("\n--- Add New Book ---");
        try {
            System.out.print("Enter book ID: ");
            int id = getIntInput();
            if (library.getBook(id) != null) {
                System.out.println("A book with this ID already exists.");
                return;
            }
            scanner.nextLine();
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter author: ");
            String author = scanner.nextLine();
            System.out.print("Enter genre: ");
            String genre = scanner.nextLine();
            System.out.print("Enter publication year: ");
            int year = getIntInput();
            System.out.print("Enter copies available: ");
            int copies = getIntInput();

            Book newBook = new Book(id, title, author, genre, year, copies);
            librarian.addBook(library, newBook);
            System.out.println("Book added successfully!");
        } catch (Exception e) {
            System.out.println("Could not add book: " + e.getMessage());
        }
    }

    private static void removeBook() {
        System.out.println("\n--- Remove Book ---");
        try {
            System.out.print("Enter book ID to remove: ");
            int id = getIntInput();
            Book book = library.getBook(id);
            if (book != null) {
                librarian.removeBook(library, book);
                System.out.println("Book removed successfully!");
            } else {
                System.out.println("Book not found with ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("Could not remove book: " + e.getMessage());
        }
    }

    private static void addMember() {
        System.out.println("\n--- Add New Member ---");
        try {
            System.out.print("Enter member ID: ");
            int id = getIntInput();
            if (library.getMember(id) != null) {
                System.out.println("A member with this ID already exists.");
                return;
            }
            scanner.nextLine();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            Member newMember = new Member(id, name, email);
            library.addMember(newMember);
            System.out.println("Member added successfully!");
        } catch (Exception e) {
            System.out.println("Could not add member: " + e.getMessage());
        }
    }

    private static void borrowBook() {
        System.out.println("\n--- Borrow Book ---");
        try {
            System.out.print("Enter member ID: ");
            int memberId = getIntInput();
            System.out.print("Enter book ID: ");
            int bookId = getIntInput();

            Member member = library.getMember(memberId);
            Book book = library.getBook(bookId);

            if (member == null) {
                System.out.println("Member not found.");
                return;
            }
            if (book == null) {
                System.out.println("Book not found.");
                return;
            }
            member.borrowBook(book);
            System.out.println("Book borrowed successfully!");
        } catch (Exception e) {
            System.out.println("Could not borrow book: " + e.getMessage());
        }
    }

    private static void returnBook() {
        System.out.println("\n--- Return Book ---");
        try {
            System.out.print("Enter member ID: ");
            int memberId = getIntInput();
            System.out.print("Enter book ID: ");
            int bookId = getIntInput();

            Member member = library.getMember(memberId);
            Book book = library.getBook(bookId);

            if (member == null) {
                System.out.println("Member not found.");
                return;
            }
            if (book == null) {
                System.out.println("Book not found.");
                return;
            }
            member.returnBook(book);
            System.out.println("Book returned successfully!");
        } catch (Exception e) {
            System.out.println("Could not return book: " + e.getMessage());
        }
    }

    private static void listAllBooks() {
        System.out.println("\n--- All Books ---");
        if (library.getBooks().isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : library.getBooks()) {
                System.out.println(book);
            }
        }
    }

    private static void listAllMembers() {
        System.out.println("\n--- All Members ---");
        if (library.getMembers().isEmpty()) {
            System.out.println("No members in the library.");
        } else {
            for (Member member : library.getMembers()) {
                System.out.println(member);
            }
        }
    }

    private static void addDigitalResource() {
        System.out.println("\n--- Add Digital Resource ---");
        try {
            System.out.print("Enter resource ID: ");
            int id = getIntInput();
            for (DigitalResource dr : digitalResources) {
                if (dr.getId() == id) {
                    System.out.println("A digital resource with this ID already exists.");
                    return;
                }
            }
            scanner.nextLine();
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter author: ");
            String author = scanner.nextLine();
            System.out.print("Enter type (e.g., PDF, Video): ");
            String type = scanner.nextLine();
            System.out.print("Enter file URL: ");
            String url = scanner.nextLine();

            digitalResources.add(new DigitalResource(id, title, author, type, url));
            System.out.println("Digital resource added successfully!");
        } catch (Exception e) {
            System.out.println("Could not add digital resource: " + e.getMessage());
        }
    }

    private static void listDigitalResources() {
        System.out.println("\n--- Digital Resources ---");
        if (digitalResources.isEmpty()) {
            System.out.println("No digital resources available.");
        } else {
            for (DigitalResource dr : digitalResources) {
                System.out.println(dr);
            }
        }
    }

    private static void addReview() {
        System.out.println("\n--- Add Review ---");
        try {
            System.out.print("Enter review ID: ");
            int id = getIntInput();
            for (Review r : reviews) {
                if (r.getId() == id) {
                    System.out.println("A review with this ID already exists.");
                    return;
                }
            }
            System.out.print("Enter book ID: ");
            int bookId = getIntInput();
            System.out.print("Enter member ID: ");
            int memberId = getIntInput();
            System.out.print("Enter rating (1-5): ");
            int rating = getIntInput();
            scanner.nextLine();
            System.out.print("Enter comment: ");
            String comment = scanner.nextLine();

            Book book = library.getBook(bookId);
            Member member = library.getMember(memberId);

            if (book == null) {
                System.out.println("Book not found.");
                return;
            }
            if (member == null) {
                System.out.println("Member not found.");
                return;
            }
            reviews.add(new Review(id, bookId, memberId, rating, comment));
            System.out.println("Review added successfully!");
        } catch (Exception e) {
            System.out.println("Could not add review: " + e.getMessage());
        }
    }

    private static void listReviews() {
        System.out.println("\n--- Reviews ---");
        if (reviews.isEmpty()) {
            System.out.println("No reviews available.");
        } else {
            for (Review review : reviews) {
                System.out.println(review.reviewDetails());
            }
        }
    }

    private static void makeReservation() {
        System.out.println("\n--- Make Reservation ---");
        try {
            System.out.print("Enter reservation ID: ");
            int id = getIntInput();
            for (Reservation r : reservations) {
                if (r.getId() == id) {
                    System.out.println("A reservation with this ID already exists.");
                    return;
                }
            }
            System.out.print("Enter book ID: ");
            int bookId = getIntInput();
            System.out.print("Enter member ID: ");
            int memberId = getIntInput();
            java.time.LocalDate today = java.time.LocalDate.now();

            Book book = library.getBook(bookId);
            Member member = library.getMember(memberId);

            if (book == null) {
                System.out.println("Book not found.");
                return;
            }
            if (member == null) {
                System.out.println("Member not found.");
                return;
            }
            for (Reservation r : reservations) {
                if (r.getBookId() == bookId && r.getMemberId() == memberId) {
                    System.out.println("This member has already reserved this book.");
                    return;
                }
            }
            reservations.add(new Reservation(id, bookId, memberId, today));
            System.out.println("Reservation made successfully!");
        } catch (Exception e) {
            System.out.println("Could not make reservation: " + e.getMessage());
        }
    }

    private static void listReservations() {
        System.out.println("\n--- Reservations ---");
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation r : reservations) {
                System.out.println(r.reservationInfo());
            }
        }
    }

    private static void payFine() {
        System.out.println("\n--- Pay Fine ---");
        try {
            System.out.print("Enter member ID: ");
            int memberId = getIntInput();
            boolean found = false;
            for (Fine fine : fines) {
                if (fine.getMemberId() == memberId && fine.getAmount() > 0) {
                    System.out.println("Outstanding fine: " + fine.getAmount());
                    System.out.print("Enter payment amount: ");
                    double payment = Double.parseDouble(scanner.nextLine());
                    fine.payFine(payment);
                    System.out.println("Fine paid successfully!");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No outstanding fines for this member.");
            }
        } catch (Exception e) {
            System.out.println("Could not pay fine: " + e.getMessage());
        }
    }

    private static void listFines() {
        System.out.println("\n--- Fines ---");
        if (fines.isEmpty()) {
            System.out.println("No fines found.");
        } else {
            for (Fine fine : fines) {
                System.out.println(fine);
            }
        }
    }

    private static void addLibraryEvent() {
        System.out.println("\n--- Add Library Event ---");
        try {
            System.out.print("Enter event ID: ");
            int id = getIntInput();
            for (LibraryEvent event : events) {
                if (event.getId() == id) {
                    System.out.println("An event with this ID already exists.");
                    return;
                }
            }
            scanner.nextLine();
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter description: ");
            String desc = scanner.nextLine();
            System.out.print("Enter date (YYYY-MM-DD): ");
            String dateStr = scanner.nextLine();
            java.time.LocalDate date;
            try {
                date = java.time.LocalDate.parse(dateStr);
            } catch (Exception e) {
                System.out.println("Invalid date format.");
                return;
            }
            events.add(new LibraryEvent(id, title, desc, date));
            System.out.println("Library event added successfully!");
        } catch (Exception e) {
            System.out.println("Could not add event: " + e.getMessage());
        }
    }

    private static void listLibraryEvents() {
        System.out.println("\n--- Library Events ---");
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            for (LibraryEvent event : events) {
                System.out.println(event.libraryEventInfo());
            }
        }
    }

    private static void addCategory() {
        System.out.println("\n--- Add Category ---");
        try {
            System.out.print("Enter category ID: ");
            int id = getIntInput();
            for (Category cat : categories) {
                if (cat.getId() == id) {
                    System.out.println("A category with this ID already exists.");
                    return;
                }
            }
            scanner.nextLine();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter description: ");
            String desc = scanner.nextLine();
            categories.add(new Category(id, name, desc));
            System.out.println("Category added successfully!");
        } catch (Exception e) {
            System.out.println("Could not add category: " + e.getMessage());
        }
    }

    private static void listCategories() {
        System.out.println("\n--- Categories ---");
        if (categories.isEmpty()) {
            System.out.println("No categories found.");
        } else {
            for (Category cat : categories) {
                System.out.println(cat.categoryDetails());
            }
        }
    }

    // Helper method to safely get integer input
    private static int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input.trim());
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
}