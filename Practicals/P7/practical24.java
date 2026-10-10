import java.util.LinkedList;
import java.util.Scanner;

class practical24 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    LinkedList<String> playlist = new LinkedList<>();

    boolean exit = false;
    while (!exit) {
      System.out.println("--- Music Playlist Manager ---");
      System.out.println("1. Add Song to End");
      System.out.println("2. Add Song to Beginning (Play Next)");
      System.out.println("3. Remove Song");
      System.out.println("4. Display Playlist");
      System.out.println("5. Exit");
      System.out.print("Enter choice (1-5): ");

      int choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Enter song title: ");
          String songToEnd = sc.nextLine().trim();
          if (!songToEnd.isEmpty()) {
            playlist.addLast(songToEnd);
            System.out.println("'" + songToEnd + "' added to the end of playlist.");
          }
          break;
        case 2:
          System.out.print("Enter song title: ");
          String songToFront = sc.nextLine().trim();
          if (!songToFront.isEmpty()) {
            playlist.addFirst(songToFront);
            System.out.println("'" + songToFront + "' added to the top of playlist.");
          }
          break;

        case 3:
          System.out.print("Enter song title to remove: ");
          String removeSong = sc.nextLine().trim();
          if (playlist.remove(removeSong)) {
            System.out.println("'" + removeSong + "' removed from the playlist.");
          }
          else {
            System.out.println("Song not found in playlist.");
          }
          break;

        case 4:
          System.out.println("--- Current Playlist ---");
          if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
          }
          else{
            int trackNumber = 1;
            for (String song: playlist) {
              System.out.println(trackNumber + ". " + song);
              trackNumber++;
            }
          }
          break;

        case 5:
          exit = true;
          System.out.println("Exiting Playlist Manager.");
        default:
          System.out.println("Invalid choice. Please select 1-5.");
          break;
      }
    }
    sc.close();
  }
}
