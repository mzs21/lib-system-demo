import java.util.Scanner;


// Main class demonstrating polymorphism through method overloading
public class Main {
    private static Library library = new Library();
    private static Librarian librarian = new Librarian(1, "Admin Librarian");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Add some sample data
        initializeSampleData();

        // Main menu loop
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

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
        // Add some books
        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925, 3));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", 1960, 2));
        library.addBook(new Book(3, "1984", "George Orwell", "Dystopian", 1949, 1));

        // Add some members
        library.addMember(new Member(1, "John Doe", "john@example.com"));
        library.addMember(new Member(2, "Jane Smith", "jane@example.com"));
    }

    private static void addBook() {
        System.out.println("\n--- Add New Book ---");
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        
        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();
        
        System.out.print("Enter copies available: ");
        int copies = scanner.nextInt();
        
        Book newBook = new Book(id, title, author, genre, year, copies);
        librarian.addBook(library, newBook);
        System.out.println("Book added successfully!");
    }

    private static void removeBook() {
        System.out.println("\n--- Remove Book ---");
        System.out.print("Enter book ID to remove: ");
        int id = scanner.nextInt();
        
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
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        Member newMember = new Member(id, name, email);
        library.addMember(newMember);
        System.out.println("Member added successfully!");
    }

    private static void borrowBook() {
        System.out.println("\n--- Borrow Book ---");
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        
        Member member = library.getMember(memberId);
        Book book = library.getBook(bookId);
        
        if (member != null && book != null) {
            member.borrowBook(book);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Member or book not found.");
        }
    }

    private static void returnBook() {
        System.out.println("\n--- Return Book ---");
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        
        Member member = library.getMember(memberId);
        Book book = library.getBook(bookId);
        
        if (member != null && book != null) {
            member.returnBook(book);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Member or book not found.");
        }
    }

    private static void listAllBooks() {
        System.out.println("\n--- All Books ---");
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
    }

    private static void listAllMembers() {
        System.out.println("\n--- All Members ---");
        for (Member member : library.getMembers()) {
            System.out.println(member);
        }
    }
}