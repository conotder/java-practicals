import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class practical14 {
  public static void main(String[] args) {
    // arranging the word of the string in decending order of length and alphabetically for words of the same length and store the output in the text file.

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string to be processed: ");
    String input = sc.nextLine().trim();

    if (input.isEmpty()) {
      System.out.println("The input string is empty");
      sc.close();
      return;
    }

    String cleanInput = input.replaceAll("[.,!?]", "");
    String[] words = cleanInput.split("\\s+");

    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words.length; j++) {
        if (words[i].length() < words[j].length() || (words[i].length() == words[j].length() && words[i].compareToIgnoreCase(words[j]) > 0)) {
          String temp = words[i];
          words[i] = words[j];
          words[j] = temp;
        }
      }
    }

    try {
      FileWriter fw = new FileWriter("sorted_words.txt");
      for (int i = 0; i < words.length; i++) {
        fw.write(words[i] + "\n");
      }
      fw.close();
      System.out.println("Done! Saved to 'sorted_words.txt'.");
    }
    catch (IOException e) {
      System.out.println("An error occurred while saving the file.");
    }

    sc.close();

  }
}
