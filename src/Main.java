import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Librarian librarian = new Librarian(1, "Admin Librarian");
    private static Scanner scanner = new Scanner(System.in);

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
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    addMember();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    listAllBooks();
                    break;
                case 7:
                    listAllMembers();
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeSampleData() {
        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925, 3));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", 1960, 2));
        library.addBook(new Book(3, "1984", "George Orwell", "Dystopian", 1949, 1));
        library.addMember(new Member(1, "John Doe", "john@example.com"));
        library.addMember(new Member(2, "Jane Smith", "jane@example.com"));
    }

    private static void addBook() {
        System.out.println("\n--- Add New Book ---");
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

        if (copies < 1) {
            System.out.println("Copies available must be at least 1.");
            return;
        }
        Book newBook = new Book(id, title, author, genre, year, copies);
        librarian.addBook(library, newBook);
        System.out.println("Book added successfully!");
    }

    private static void removeBook() {
        System.out.println("\n--- Remove Book ---");
        System.out.print("Enter book ID to remove: ");
        int id = getIntInput();
        Book book = library.getBook(id);
        if (book != null) {
            librarian.removeBook(library, book);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found with ID: " + id);
        }
    }

    private static void addMember() {
        System.out.println("\n--- Add New Member ---");
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
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Invalid email address.");
            return;
        }
        Member newMember = new Member(id, name, email);
        library.addMember(newMember);
        System.out.println("Member added successfully!");
    }

    private static void borrowBook() {
        System.out.println("\n--- Borrow Book ---");
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
        if (member.getBorrowedBooks().contains(book)) {
            System.out.println("This member has already borrowed this book.");
            return;
        }
        int maxBorrowLimit = 5;
        if (member.getBorrowedBooks().size() >= maxBorrowLimit) {
            System.out.println("This member has reached the borrowing limit (" + maxBorrowLimit + " books).");
            return;
        }
        try {
            member.borrowBook(book);
            System.out.println("Book borrowed successfully!");
        } catch (Exception e) {
            System.out.println("Error borrowing book: " + e.getMessage());
        }
    }

    private static void returnBook() {
        System.out.println("\n--- Return Book ---");
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
        if (!member.getBorrowedBooks().contains(book)) {
            System.out.println("This book was not borrowed by the member.");
            return;
        }
        try {
            member.returnBook(book);
            System.out.println("Book returned successfully!");
        } catch (Exception e) {
            System.out.println("Error returning book: " + e.getMessage());
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