import java.io.*;
import java.util.Scanner;

public class NotesApp {

    private static final String FILE_NAME = "notes.txt";

    // Add a note to the file
    public static void addNote(String note) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) { // append mode = true
            writer.write(note + System.lineSeparator());
            System.out.println("✅ Note added successfully!");
        } catch (IOException e) {
            System.out.println("⚠️ Error writing to file: " + e.getMessage());
        }
    }

    // View all notes
    public static void viewNotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n📒 Your Notes:");
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ No notes found! Start by adding some.");
        } catch (IOException e) {
            System.out.println("⚠️ Error reading file: " + e.getMessage());
        }
    }

    // Clear all notes (overwrite mode)
    public static void clearNotes() {
        try (FileWriter writer = new FileWriter(FILE_NAME, false)) {
            writer.write(""); // overwrite file with empty content
            System.out.println("🗑 All notes cleared!");
        } catch (IOException e) {
            System.out.println("⚠️ Error clearing notes: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Notes Manager =====");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Clear Notes");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = sc.nextLine();
                    addNote(note);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    clearNotes();
                    break;
                case 4:
                    System.out.println("👋 Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
