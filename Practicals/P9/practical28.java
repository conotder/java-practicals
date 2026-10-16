import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class InvalidUserException extends Exception {
  public InvalidUserException(String message) {
    super(message);
  }
}

public class practical28 {
  private static final String FILE_NAME = "user_records.txt";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter details in format 'Name,Age,Email':");
    String input = scanner.nextLine().trim();

    try {
      validateAndSave(input);
      System.out.println("Record processed and saved successfully!");
    } catch (InvalidUserException | IOException e) {
      System.out.println("Error: " + e.getMessage());
    }

    displayRecords();
    scanner.close();
  }

  private static void validateAndSave(String text) throws InvalidUserException, IOException {
    // Stream verification: Must contain exactly 2 commas
    long commaCount = text.chars().filter(ch -> ch == ',').count();
    if (commaCount != 2) {
      throw new InvalidUserException("Input format must contain exactly two commas.");
    }

    // Extracting fields using dynamic substring offsets instead of arrays
    int firstComma = text.indexOf(',');
    int secondComma = text.indexOf(',', firstComma + 1);

    String name = text.substring(0, firstComma).trim();
    String ageStr = text.substring(firstComma + 1, secondComma).trim();
    String email = text.substring(secondComma + 1).trim();

    if (name.isEmpty() || ageStr.isEmpty() || email.isEmpty()) {
      throw new InvalidUserException("All input fields are mandatory.");
    }

    // Stream verification: Age string must consist solely of digits
    boolean isNumericAge = !ageStr.isEmpty() && ageStr.chars().allMatch(Character::isDigit);
    if (!isNumericAge) {
      throw new InvalidUserException("Age field must contain numbers only.");
    }

    int age = Integer.parseInt(ageStr);
    if (age < 0 || age > 120) {
      throw new InvalidUserException("Age out of human range (0-120).");
    }

    // Stream verification: Email must contain structural characters
    if (email.chars().noneMatch(c -> c == '@') || email.chars().noneMatch(c -> c == '.')) {
      throw new InvalidUserException("Invalid email format mapping.");
    }

    String record = "Name: " + name + " | Age: " + age + " | Email: " + email + "\n";
    try (FileOutputStream fos = new FileOutputStream(FILE_NAME, true)) {
      fos.write(record.getBytes());
    }
  }

  private static void displayRecords() {
    System.out.println("\n--- Current Saved Records ---");
    try (FileInputStream fis = new FileInputStream(FILE_NAME);
         InputStreamReader isr = new InputStreamReader(fis);
         BufferedReader br = new BufferedReader(isr)) {
      
      br.lines().forEach(System.out::println);
    } catch (IOException e) {
      System.out.println("No records found or unable to read file.");
    }
  }
}

