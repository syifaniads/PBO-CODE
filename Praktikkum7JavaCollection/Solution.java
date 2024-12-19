package Praktikkum7JavaCollection;
import java.util.*;

class LibrarySystem {
    private Set<Book> bookCatalog;

    public LibrarySystem() {
        this.bookCatalog = new HashSet<>();
    }

    public boolean addBook(int isbn, String title, String author, int yearPublished) {
        Book newBook = new Book(isbn, title, author, yearPublished);
        if (bookCatalog.contains(newBook)) {
            System.out.println("Book already exists in the catalog.");
            return false;
        } else {
            bookCatalog.add(newBook);
            System.out.println("Book added successfully!");
            return true;
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Book book : bookCatalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No book found with the title: " + title);
        }
    }

    public void displayAllBooks() {
        if (bookCatalog.isEmpty()) {
            System.out.println("The book catalog is currently empty.");
        } else {
            Map<Integer, Integer> isbnCounts = new HashMap<>();
            for (Book book : bookCatalog) {
                int isbn = book.getIsbn();
                isbnCounts.put(isbn, isbnCounts.getOrDefault(isbn, 0) + 1);
            }
            List<Map.Entry<Integer, Integer>> sortedIsbnCounts = new ArrayList<>(isbnCounts.entrySet());
            sortedIsbnCounts.sort((a, b) -> {
                int countComparison = b.getValue().compareTo(a.getValue());
                if (countComparison != 0) {
                    return countComparison; // If counts are different, sort by count
                } else {
                    // If counts are the same, sort by length of ISBN
                    String isbnA = String.valueOf(a.getKey());
                    String isbnB = String.valueOf(b.getKey());
                    return Integer.compare(isbnB.length(), isbnA.length());
                }
            });
            for (Map.Entry<Integer, Integer> entry : sortedIsbnCounts) {
                int isbn = entry.getKey();
                int count = entry.getValue();
                for (Book book : bookCatalog) {
                    if (book.getIsbn() == isbn) {
                        System.out.println("Book{isbn='" + isbn + "'"+ ", title='" + book.getTitle() + "'"+ ", author='" + book.getAuthor() + "'"+ ", yearPublished=" + book.getYearPublished() + "}");
                    }
                }
            }
        }
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibrarySystem library = new LibrarySystem();

        while (true) {
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        int isbn = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        String title = scanner.nextLine();
                        String author = scanner.nextLine();
                        int yearPublished = scanner.nextInt();
                        library.addBook(isbn, title, author, yearPublished);
                        break;
                    case 2:
                        scanner.nextLine();
                        String searchTitle = scanner.nextLine();
                        library.searchByTitle(searchTitle);
                        break;
                    case 3:
                        library.displayAllBooks();
                        break;
                    case 4:
                        System.out.println("Exiting the system.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option, please choose again.");
                        break;
                }
            }
        }
}
class Book {
    private int isbn;
    private String title;
    private String author;
    private int yearPublished;

    public Book(int isbn, String title, String author, int yearPublished) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    @Override
    public String toString() {
        return "Book{isbn='" + isbn + "', title='" + title + "', author='" + author + "', yearPublished=" + yearPublished + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn == book.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}