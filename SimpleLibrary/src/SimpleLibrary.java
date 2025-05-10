import java.util.*;

public class SimpleLibrary {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. View Issued Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> issueBook();
                case 3 -> returnBook();
                case 4 -> searchBook();
                case 5 -> viewIssuedBooks();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    private static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = scanner.nextInt();
        Book book = findBookById(id);
        if (book != null && !book.isIssued) {
            book.isIssued = true;
            System.out.println("Book issued successfully!");
        } else if (book != null) {
            System.out.println("Book is already issued.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = scanner.nextInt();
        Book book = findBookById(id);
        if (book != null && book.isIssued) {
            book.isIssued = false;
            System.out.println("Book returned successfully!");
        } else if (book != null) {
            System.out.println("Book was not issued.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void searchBook() {
        System.out.print("Enter Book ID to search: ");
        int id = scanner.nextInt();
        Book book = findBookById(id);
        if (book != null) {
            System.out.println("ID: " + book.id);
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("Status: " + (book.isIssued ? "Issued" : "Available"));
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void viewIssuedBooks() {
        System.out.println("Issued Books:");
        for (Book book : books) {
            if (book.isIssued) {
                System.out.println("ID: " + book.id + ", Title: " + book.title);
            }
        }
    }

    private static Book findBookById(int id) {
        for (Book book : books) {
            if (book.id == id) {
                return book;
            }
        }
        return null;
    }
}
