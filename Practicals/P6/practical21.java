import java.util.Scanner;
import java.util.Stack;

public class practical21 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Stack<String> backStack = new Stack<>();
    Stack<String> forwardStack = new Stack<>();
    String currentPage = "Home Page";

    boolean exit = false;
    while (!exit) {
      System.out.println("\n-------------------------------------");
      System.out.println("Current Page: " + currentPage);
      System.out.println("-------------------------------------");
      System.out.println("1. Visit New Page");
      System.out.println("2. Go Back");
      System.out.println("3. Go Forward");
      System.out.println("4. Exit");
      System.out.print("Choose an option (1-4): ");

      int choice = scanner.nextInt();
      scanner.nextLine(); 

      switch (choice) {
        case 1:
          System.out.print("Enter website URL: ");
          String newPage = scanner.nextLine();
          backStack.push(currentPage);
          currentPage = newPage;
          forwardStack.clear(); 
          break;

        case 2:
          if (!backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
          } else {
            System.out.println("Error: No history to go back to!");
          }
          break;

        case 3:
          if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
          } else {
            System.out.println("Error: No pages ahead!");
          }
          break;

        case 4:
          exit = true;
          System.out.println("Exiting browser history simulator.");
          break;

        default:
          System.out.println("Invalid option. Please choose between 1 and 4.");
      }
    }
    scanner.close();
  }
}

