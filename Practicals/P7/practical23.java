import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class practical23 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Queue<String> line = new LinkedList<>();

    boolean exit = false;
    while (!exit) {
      System.out.println("--- Queue Operation ---");
      System.out.println("1. Add Element (Enqueue)");
      System.out.println("2. Remove Element (Dequeue)");
      System.out.println("3. Print Queue Element");
      System.out.println("4. Exit");
      System.out.print("Enter choice (1-4): ");

      int choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Enter value to add: ");
          String value = sc.nextLine().trim();
          if (!value.isEmpty()) {
            line.add(value);
            System.out.println("'" + value + "' added to the queue.");
          }
          break;
        
        case 2:
          if (!line.isEmpty()) {
            String removed = line.poll();
            System.out.println("Removed front element: '" + removed + "'");
          }
          else {
            System.out.println("Queue is empty! Nothing to remove.");
          }
          break;

        case 3:
          System.out.println("--- Current Queue (Front to Back) ---");
          if (line.isEmpty()) {
            System.out.println("Queue is empty");
          }
          else {
            System.out.println(line);
          }
          break;

        case 4:
          exit = true;
          System.out.println("Exiting Queue Program.");
          break;

        default:
          System.out.println("Invalid choice. Please select 1-4.");
      }
    }
    sc.close();
  }
}
