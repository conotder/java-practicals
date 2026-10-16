import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

class practical29 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the source file name: ");
    String sourceFile = sc.nextLine().trim();

    System.out.print("Enter the backup file name: ");
    String backupFile = sc.nextLine().trim();

    try(FileInputStream fis = new FileInputStream(sourceFile);
        FileOutputStream fos = new FileOutputStream(backupFile)) {
      byte[] buffer = new byte[1024];
      int bytesRead;

      while((bytesRead = fis.read(buffer)) != -1) {
        fos.write(buffer, 0, bytesRead);
      }

      System.out.println("Success! Backup file created successfully.");
    }
    catch (IOException e) {
      System.out.println("Error performing backup: " + e.getMessage());
    }
    sc.close();
  }
}
