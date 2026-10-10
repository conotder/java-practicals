import java.util.TreeSet;
import java.util.Scanner;

class practical25 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    TreeSet<String> cities = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    boolean exit = false;
    while (!exit) {
      System.out.println("--- City Manager ---");
      System.out.println("1. Add City");
      System.out.println("2. Remove City");
      System.out.println("3. Display Cities (Alphabetical)");
      System.out.println("4. Exit");
      System.out.print("Enter choice (1-4): ");

      int choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Enter city name to add: ");
          String newCity = sc.nextLine().trim();
          if (!newCity.isEmpty()) {
            if (cities.add(newCity)) {
              System.out.println(newCity + " added successfully.");
            }
            else {
              System.out.println(newCity + " already exists in the list.");
            }
          }
          break;

        case 2:
          System.out.print("Enter city name to remove: ");
          String removeCity = sc.nextLine().trim();
          if (cities.remove(removeCity)) {
            System.out.println(removeCity + " removed from the list.");
          }
          else {
            System.out.println(removeCity + " not found in the list.");
          }
          break;

        case 3:
          System.out.println("--- Sorted City List ---");
          if (cities.isEmpty()) {
            System.out.println("No cities in the list.");
          }
          else {
            for (String city : cities) {
              System.out.println("- " + city);
            }
          }
          break;

        case 4:
          exit = true;
          System.out.println("Exiting City Manager.");
          break;

        default:
          System.out.println("Invalid choice. Please select 1-4.");
      }
    }
    sc.close();
  }
}
