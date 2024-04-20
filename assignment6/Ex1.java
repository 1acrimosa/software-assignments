import java.util.HashMap;
import java.util.Map;


class Book {
      private String title;
      private String author;
      private boolean available;

      public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.available = true;
      }

      public String getTitle() {
            return title;
      }

      public String getAuthor() {
            return author;
      }

      public boolean isAvailable() {
            return available;
      }

      public void setAvailable(boolean available) {
            this.available = available;
      }
}

class BookInventorySystem {
      private Map<String, Book> books;

      public BookInventorySystem() {
            this.books = new HashMap<>();

            books.put("1", new Book("The Great Gatsby", "F. Scott Fitzgerald"));
            books.put("2", new Book("To Kill a Mockingbird", "Harper Lee"));
            books.put("3", new Book("1984", "George Orwell"));
            books.put("4", new Book("Pride and Prejudice", "Jane Austen"));
            books.put("5", new Book("The Catcher in the Rye", "J.D. Salinger"));
            books.put("6", new Book("The Lord of the Rings", "J.R.R. Tolkien"));
            books.put("7", new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling"));
            books.put("8", new Book("To the Lighthouse", "Virginia Woolf"));
            books.put("9", new Book("One Hundred Years of Solitude", "Gabriel García Márquez"));
            books.put("10", new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams"));
            books.put("11", new Book("Moby-Dick", "Herman Melville"));
            books.put("12", new Book("The Picture of Dorian Gray", "Oscar Wilde"));

      }

      public boolean checkAvailability(String bookId) {
            Book book = books.get(bookId);
            return book != null && book.isAvailable();
      }

      public void borrowBook(String bookId) {
            Book book = books.get(bookId);
            if (book != null && book.isAvailable()) {
                  book.setAvailable(false); // Mark the book as borrowed
                  System.out.println("Book borrowed successfully: " + book.getTitle());
            } else {
                  System.out.println("Book is not available for borrowing");
            }
      }

      public void returnBook(String bookId) {
            Book book = books.get(bookId);
            if (book != null && !book.isAvailable()) {
                  book.setAvailable(true); // Mark the book as returned
                  System.out.println("Book returned successfully: " + book.getTitle());
            } else {
                  System.out.println("Invalid book or already returned");
            }
      }

      public void searchByTitle(String title) {
            System.out.println("Search Results for title: " + title);
            for (Book book : books.values()) {
                  if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                        System.out.println(book.getTitle() + " by " + book.getAuthor());
                  }
            }
      }

      public void searchByAuthor(String author) {
            System.out.println("Search Results for author: " + author);
            for (Book book : books.values()) {
                  if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                        System.out.println(book.getTitle() + " by " + book.getAuthor());
                  }
            }
      }
}

class LibraryFacade {
      private BookInventorySystem bookInventorySystem;

      public LibraryFacade() {
            this.bookInventorySystem = new BookInventorySystem();
      }

      public void borrowBook(String bookId) {
            bookInventorySystem.borrowBook(bookId);
      }

      public void returnBook(String bookId) {
            bookInventorySystem.returnBook(bookId);
      }

      public void searchByTitle(String title) {
            bookInventorySystem.searchByTitle(title);
      }

      public void searchByAuthor(String author) {
            bookInventorySystem.searchByAuthor(author);
      }

      public void checkAvailability(String bookId) {
            if (bookInventorySystem.checkAvailability(bookId)) {
                  System.out.println("Book is available");
            } else {
                  System.out.println("Book is not available");
            }
      }
}

public class Ex1 {
      public static void main(String[] args) {
            LibraryFacade libraryFacade = new LibraryFacade();

            // Test the facade methods
            libraryFacade.searchByTitle("1984");
            libraryFacade.searchByAuthor("Harper Lee");
            libraryFacade.checkAvailability("1");
            libraryFacade.borrowBook("1");
            libraryFacade.borrowBook("2");
            libraryFacade.returnBook("1");
      }
}
