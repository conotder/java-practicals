import java.util.ArrayList;
import java.util.Scanner;

class practical22 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> fruitStock = new ArrayList<>();

    boolean exit = false;
    while(!exit) {
      System.out.println("--- Fruit Stock Management ---");
      System.out.println("1. Add Fruit");
      System.out.println("2. Remove Fruit");
      System.out.println("3. Check If Fruit Exists");
      System.out.println("4. Display All Fruits");
      System.out.println("5. Exit");
      System.out.print("Enter choise (1-5): ");

      int choise = sc.nextInt();
      sc.nextLine();

      switch (choise) {
        case 1:
          System.out.print("Enter fruit name to add: ");
          String newFruit = sc.nextLine().trim();
          if (!newFruit.isEmpty()) {
            fruitStock.add(newFruit);
            System.out.println(newFruit + " added to stock.");
          }
          break;

        case 2:
          System.out.print("Enter fruit name to remove: ");
          String removeFruit = sc.nextLine().trim();
          if (fruitStock.remove(removeFruit)) {
            System.out.println(removeFruit + " removed from the stock");
          }
          else {
            System.out.println(removeFruit + " not found in stock.");
          }
          break;

        case 3:
          System.out.print("Enter fruit name to search: ");
          String searchFruit = sc.nextLine().trim();
          if (fruitStock.contains(searchFruit)) {
            System.out.println(searchFruit + " is available in stock");
          }
          break;

        case 4:
          System.out.println("--- Currebt Inventory ---");
          if (fruitStock.isEmpty()) {
          System.out.println("Stock is empty.");
          }
          else {
            for (String fruit: fruitStock) {
              System.out.println("- " + fruit);
            }
          }
        case 5:
          exit = true;
          System.out.println("Exiting Stock Manager,");
          break;

        default:
          System.out.println("Invalid choise. Please selet 1-5.");
      }
    }
    sc.close();
  }
}
