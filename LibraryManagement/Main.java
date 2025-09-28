import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n--- 📚 Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. View Books");
            System.out.println("4. View Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                }
                case 2 -> {
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String uname = sc.nextLine();
                    library.addUser(new User(uid, uname));
                }
                case 3 -> library.viewBooks();
                case 4 -> library.viewUsers();
                case 5 -> {
                    System.out.print("Enter Book ID to issue: ");
                    int bid = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    library.issueBook(bid, uid);
                }
                case 6 -> {
                    System.out.print("Enter Book ID to return: ");
                    int rid = sc.nextInt();
                    library.returnBook(rid);
                }
                case 7 -> System.out.println("👋 Exiting Library System...");
                default -> System.out.println("❌ Invalid choice!");
            }
        } while (choice != 7);

        sc.close();
    }
}
