import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added: " + book.getTitle());
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("✅ User added: " + user.getName());
    }

    public void issueBook(int bookId, int userId) {
        for (Book book : books) {
            if (book.getId() == bookId && !book.isIssued()) {
                book.issue();
                System.out.println("📖 Book '" + book.getTitle() + "' issued to User ID " + userId);
                return;
            }
        }
        System.out.println("❌ Book not available or already issued.");
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId && book.isIssued()) {
                book.returnBook();
                System.out.println("✅ Book '" + book.getTitle() + "' returned.");
                return;
            }
        }
        System.out.println("❌ Book not found or not issued.");
    }

    public void viewBooks() {
        System.out.println("\n--- 📚 Library Books ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void viewUsers() {
        System.out.println("\n--- 👥 Library Users ---");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
