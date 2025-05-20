import java.time.LocalDate;
import java.util.*;



public class Main {
    private static Library library = new Library();
    private static Librarian librarian = new Librarian(1, "Admin Librarian");
    private static List<LibraryEvent> events = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    private static List<DigitalResource> digitalResources = new ArrayList<>();

    private static List<Review> reviews = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();


    private static List<Loan> loans = new ArrayList<>();
    private static List<Fine> fines = new ArrayList<>();
    


    public static void main(String[] args) {
        initializeSampleData();
        Scanner scanner = new Scanner(System.in);
        boolean systemRunning = true;
    
        while (systemRunning) {
            System.out.println("=== Welcome to Library Management System ===");
            System.out.println("Select your role:");
            System.out.println("1. Librarian");
            System.out.println("2. Member");
            System.out.println("0. Exit System");
            System.out.print("Enter choice: ");
            int roleChoice = getIntInput();
    
            if (roleChoice == 1 || roleChoice == 2) {
                boolean roleRunning = true;
                while (roleRunning) {
                    if (roleChoice == 1) {
                        displayLibrarianMenu();
                        int choice = getIntInput();
                        if (choice < 1 || choice > 25) {
                            System.out.println("Invalid choice! Please enter a number between 1 and 25.");
                            continue;
                        }
                        roleRunning = handleLibrarianActions(choice);
                    } else {
                        displayMemberMenu();
                        int choice = getIntInput();
                        if (choice < 1 || choice > 15) {
                            System.out.println("Invalid choice! Please enter a number between 1 and 15.");
                            continue;
                        }
                        roleRunning = handleMemberActions(choice);
                    }
                }
            } else if (roleChoice == 0) {
                exitSystem();
            } else {
                System.out.println("Invalid role selected. Exiting.");
                systemRunning = false;
            }
        }
    
        scanner.close();
    }

private static void displayLibrarianMenu() {
    System.out.println("\n===== Librarian Menu =====");
    System.out.println("1. Add Book");
    System.out.println("2. Remove Book");
    System.out.println("3. List All Books");
    System.out.println("4. Add Digital Resource");
    System.out.println("5. Remove Digital Resource");
    System.out.println("6. List Digital Resources");
    System.out.println("7. Add Member");
    System.out.println("8. Remove Member");
    System.out.println("9. List All Members");
    System.out.println("10. Borrow Book");
    System.out.println("11. Return Book");
    System.out.println("12. Assign Fine");
    System.out.println("13. Pay Fine");
    System.out.println("14. List Fines");
    System.out.println("15. List Loans");
    System.out.println("16. Add Review");
    System.out.println("17. List Reviews");
    System.out.println("18. Make Reservation");
    System.out.println("19. List Reservations");
    System.out.println("20. List Categories");
    System.out.println("21. Add Library Event");
    System.out.println("22. List Library Events");
    System.out.println("23. Remove Library Event");
    System.out.println("24. Switch Role");
System.out.println("25. Exit System");
    System.out.print("Enter your choice: ");
}

private static void displayMemberMenu() {
    System.out.println("\n===== Member Menu =====");
    System.out.println("1. List All Books");
    System.out.println("2. List Digital Resources");
    System.out.println("3. Borrow Book");
    System.out.println("4. Return Book");
    System.out.println("5. Pay Fine");
    System.out.println("6. List Fines");
    System.out.println("7. List Loans");
    System.out.println("8. Add Review");
    System.out.println("9. List Reviews");
    System.out.println("10. Make Reservation");
    System.out.println("11. List Reservations");
    System.out.println("12. List Categories");
    System.out.println("13. List Library Events");
    System.out.println("14. Switch Role");
System.out.println("15. Exit System");
    System.out.print("Enter your choice: ");
}

private static boolean handleLibrarianActions(int choice) {
    switch (choice) {
        case 1: addBook(); break;
        case 2: removeBook(); break;
        case 3: listAllBooks(); break;
        case 4: addDigitalResource(); break;
        case 5: removeDigitalResource(); break;
        case 6: listDigitalResources(); break;
        case 7: addMember(); break;
        case 8: removeMember(); break;
        case 9: listAllMembers(); break;
        case 10: borrowBook(); break;
        case 11: returnBook(); break;
        case 12: assignFine(); break;
        case 13: payFine(); break;
        case 14: listFines(); break;
        case 15: listLoans(); break;
        case 16: addReview(); break;
        case 17: listReviews(); break;
        case 18: makeReservation(); break;
        case 19: listReservations(); break;
        case 20: listCategories(); break;
        case 21: addLibraryEvent(); break;
        case 22: listLibraryEvents(); break;
        case 23: removeLibraryEvent(); break;
        case 24: return false;
case 25: exitSystem();  break;
        default: System.out.println("Invalid librarian option.");
    }
    return true;
}


private static boolean handleMemberActions(int choice) {
    switch (choice) {
        case 1: listAllBooks(); break;
        case 2: listDigitalResources(); break;
        case 3: borrowBook(); break;
        case 4: returnBook(); break;
        case 5: payFine(); break;
        case 6: listFines(); break;
        case 7: listLoans(); break;
        case 8: addReview(); break;
        case 9: listReviews(); break;
        case 10: makeReservation(); break;
        case 11: listReservations(); break;
        case 12: listCategories(); break;
        case 13: listLibraryEvents(); break;
        case 14: return false; 
case 15: exitSystem(); 
            break;
        default:
            System.out.println("Invalid member option.");
    }
    return true;
}

private static void exitSystem() {
    System.out.println("Returning to role selection...");
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
    
    private static void initializeSampleData() {

        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925, 3));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", 1960, 2));
        library.addBook(new Book(3, "1984", "George Orwell", "Dystopian", 1949, 1));
        library.addMember(new Member(1, "John Doe", "john@example.com"));
        library.addMember(new Member(2, "Jane Smith", "jane@example.com"));

        digitalResources.add(new DigitalResource(1, "Digital Math Book", "Prof. Euler", "PDF", "http://math.com/book.pdf"));
        digitalResources.add(new DigitalResource(2, "History Documentary", "Dr. Smith", "Video", "http://history.com/doc.mp4"));

        events.add(new LibraryEvent(1, "Book Fair", "Annual book fair event", java.time.LocalDate.now().plusDays(10)));
    }

private static void addLibraryEvent() {
    System.out.println("\n--- Add Library Event ---");
    try {
        System.out.print("Enter event ID: ");
        int id = getIntInput();

        if (id <= 0) {
            throw new IllegalArgumentException("Event ID must be a positive number.");
        }

        // Check for duplicate ID
        for (LibraryEvent event : events) {
            if (event.getId() == id) {
                System.out.println("An event with this ID already exists.");
                return;
            }
        }

        scanner.nextLine(); // Consume newline

        System.out.print("Enter title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Event title cannot be empty.");
        }

        System.out.print("Enter description: ");
        String desc = scanner.nextLine().trim();
        if (desc.isEmpty()) {
            throw new IllegalArgumentException("Event description cannot be empty.");
        }

        System.out.print("Enter date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine().trim();
        LocalDate date;

        try {
            date = LocalDate.parse(dateStr);
            if (date.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Event date cannot be in the past.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format. Please use YYYY-MM-DD.");
        }

        events.add(new LibraryEvent(id, title, desc, date));
        System.out.println("Library event added successfully!");
    } catch (Exception e) {
        System.out.println("Could not add event: " + e.getMessage());
    }
}


private static void removeLibraryEvent() {
    System.out.println("\n--- Remove Library Event ---");
    try {
        System.out.print("Enter event ID to remove: ");
        int id = getIntInput();

        if (id <= 0) {
            throw new IllegalArgumentException("Event ID must be a positive number.");
        }

        boolean removed = events.removeIf(event -> event.getId() == id);
        if (removed) {
            System.out.println("Library event removed successfully!");
        } else {
            System.out.println("No library event found with that ID.");
        }
    } catch (Exception e) {
        System.out.println("Could not remove event: " + e.getMessage());
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


    


    

    private static void addBook() {
        System.out.println("\n--- Add New Book ---");
        try {
            System.out.print("Enter book ID: ");
            int id = getIntInput();
            if (id <= 0) {
                throw new IllegalArgumentException("Book ID must be a positive number.");
            }
            if (library.getBook(id) != null) {
                System.out.println("A book with this ID already exists.");
                return;
            }
    
            scanner.nextLine(); // consume leftover newline
    
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter author: ");
            String author = scanner.nextLine();
            System.out.print("Enter category: ");
            String category = scanner.nextLine().trim();
    
            if (category.isEmpty()) {
                throw new IllegalArgumentException("Category cannot be empty.");
            }
    
            System.out.print("Enter publication year: ");
            int year = getIntInput();
            if (year <= 0) {
                throw new IllegalArgumentException("Publication year must be a positive number.");
            }
    
            System.out.print("Enter copies available: ");
            int copies = getIntInput();
            if (copies <= 0) {
                throw new IllegalArgumentException("Copies available must be a positive number.");
            }
    
            Book newBook = new Book(id, title, author, category, year, copies);
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

    private static void addDigitalResource() {
        System.out.println("\n--- Add Digital Resource ---");
        try {
            System.out.print("Enter resource ID: ");
            int id = getIntInput();

            if (id <= 0) {
                throw new IllegalArgumentException("DigitalResource ID must be a positive number.");
            }

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

    private static void removeDigitalResource() { 
        System.out.println("\n--- Remove Digital Resource ---");
        System.out.print("Enter resource ID to remove: ");
        int id = getIntInput();
        boolean removed = digitalResources.removeIf(dr -> dr.getId() == id);
        if (removed) {
            System.out.println("Digital resource removed successfully!");
        } else {
            System.out.println("No digital resource found with that ID.");
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

    
    private static void listCategories() {
        System.out.println("\n--- Categories ---");
    
        Map<String, Integer> totalBooksPerCategory = new HashMap<>();
        Map<String, Integer> availableCopiesPerCategory = new HashMap<>();
    
        for (Book book : library.getBooks()) {
            String category = book.getCategoryName();
            totalBooksPerCategory.put(category, totalBooksPerCategory.getOrDefault(category, 0) + 1);
            availableCopiesPerCategory.put(category,
                    availableCopiesPerCategory.getOrDefault(category, 0) + book.getCopiesAvailable());
        }
    
        if (totalBooksPerCategory.isEmpty()) {
            System.out.println("No categories found.");
        } else {
            for (Map.Entry<String, Integer> entry : totalBooksPerCategory.entrySet()) {
                String category = entry.getKey();
                int totalBooks = entry.getValue();
                int availableCopies = availableCopiesPerCategory.get(category);
                System.out.printf("Category: %s | Total Books: %d | Available Copies: %d\n", category, totalBooks, availableCopies);
            }
        }
    }


    


    private static void borrowBook() {
        System.out.println("\n--- Borrow Book ---");
        try {
            System.out.print("Enter member ID: ");
            int memberId = getIntInput();

            if (memberId <= 0) {
                throw new IllegalArgumentException("Member ID must be a positive number.");
            }

            System.out.print("Enter book ID: ");
            int bookId = getIntInput();

            if (bookId <= 0) {
                throw new IllegalArgumentException("Book ID must be a positive number.");
            }
    
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
            // Add Loan record
            loans.add(new Loan(bookId, memberId, java.time.LocalDate.now(), null));
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

            if (memberId <= 0) {
                throw new IllegalArgumentException("Member ID must be a positive number.");
            }


            System.out.print("Enter book ID: ");
            int bookId = getIntInput();

            if (bookId <= 0) {
                throw new IllegalArgumentException("Book ID must be a positive number.");
            }
    
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
            for (Loan loan : loans) {
                if (loan.getBookId() == bookId && loan.getMemberId() == memberId && loan.getReturnDate() == null) {
                    loan.setReturnDate(java.time.LocalDate.now());
                    break;
                }
            }

            System.out.println("Book returned successfully!");
        } catch (Exception e) {
            System.out.println("Could not return book: " + e.getMessage());
        }
    }

    private static void listLoans() {
        System.out.println("\n--- Loans ---");
        if (loans.isEmpty()) {
            System.out.println("No loans found.");
        } else {
            for (Loan loan : loans) {
                System.out.println(loan.loanDetails());
            }
        }
    }



    private static void addMember() {
        System.out.println("\n--- Add New Member ---");
        try {
            System.out.print("Enter member ID: ");
            int id = getIntInput();

            if (id <= 0) {
                throw new IllegalArgumentException("Member ID must be a positive number.");
            }
            
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

    private static void removeMember() {
        System.out.println("\n--- Remove Member ---");
        System.out.print("Enter member ID to remove: ");
        int id = getIntInput();
        Member member = library.getMember(id);
        if (member != null) {
            library.removeMember(member);
            // Optionally, clean up related data:
            loans.removeIf(loan -> loan.getMemberId() == id);
            fines.removeIf(fine -> fine.getMemberId() == id);
            reservations.removeIf(res -> res.getMemberId() == id);
            System.out.println("Member and related records removed successfully!");
        } else {
            System.out.println("Member not found with ID: " + id);
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



private static void addReview() {
    System.out.println("\n--- Add Review ---");
    try {
        System.out.print("Enter review ID: ");
        int id = getIntInput();
        if (id <= 0) {
            throw new IllegalArgumentException("Review ID must be a positive number.");
        }
        for (Review r : reviews) {
            if (r.getId() == id) {
                System.out.println("A review with this ID already exists.");
                return;
            }
        }

        System.out.print("Enter book ID: ");
        int bookId = getIntInput();
        if (bookId <= 0) {
            throw new IllegalArgumentException("Book ID must be a positive number.");
        }

        System.out.print("Enter member ID: ");
        int memberId = getIntInput();
        if (memberId <= 0) {
            throw new IllegalArgumentException("Member ID must be a positive number.");
        }

        System.out.print("Enter rating (1-5): ");
        int rating = getIntInput();
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }

        scanner.nextLine(); // Consume newline
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
            if (id <= 0) {
                throw new IllegalArgumentException("Reservation ID must be a positive number.");
            }
    
            // Check if reservation ID is taken
            for (Reservation r : reservations) {
                if (r.getId() == id) {
                    System.out.println("A reservation with this ID already exists.");
                    return;
                }
            }
    
            System.out.print("Enter book ID: ");
            int bookId = getIntInput();
            if (bookId <= 0) {
                throw new IllegalArgumentException("Book ID must be a positive number.");
            }
    
            System.out.print("Enter member ID: ");
            int memberId = getIntInput();
            if (memberId <= 0) {
                throw new IllegalArgumentException("Member ID must be a positive number.");
            }
    
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
    
            // Check for existing reservation by the same member for the same book
            for (Reservation r : reservations) {
                if (r.getBookId() == bookId && r.getMemberId() == memberId) {
                    System.out.println("This member has already reserved this book.");
                    return;
                }
            }
    
            // Create new reservation
            java.time.LocalDate today = java.time.LocalDate.now();
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

            
            if (memberId <= 0) {
                throw new IllegalArgumentException("Member ID must be a positive number.");
            }

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


    private static void assignFine() {
        System.out.println("\n--- Assign Fine ---");
        System.out.print("Enter member ID: ");
        int memberId = getIntInput();

        
        if (memberId <= 0) {
            throw new IllegalArgumentException("Member ID must be a positive number.");
        }

        System.out.print("Enter fine amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        fines.add(new Fine(memberId, amount));
        System.out.println("Fine assigned.");
    }


}