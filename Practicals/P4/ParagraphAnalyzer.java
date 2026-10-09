import java.util.Scanner;

public class ParagraphAnalyzer {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 1. Get user input
    System.out.println("Enter a paragraph:");
    String paragraph = scanner.nextLine();

    // 2. Perform counts
    int wordCount = countWords(paragraph);
    int sentenceCount = countSentences(paragraph);

    // Display basic counts
    System.out.println("\n--- Analysis Results ---");
    System.out.println("Total Words: " + wordCount);
    System.out.println("Total Sentences: " + sentenceCount);

    // 3. Character Frequency Analysis
    System.out.println("\nCharacter Frequency (Ignoring case & spaces):");
    displayCharacterFrequency(paragraph);

    // 4. Word Search
    System.out.print("\nEnter a word to search for: ");
    String searchWord = scanner.next();
    int wordOccurrence = searchWord(paragraph);
    System.out.println("The word '" + searchWord + "' appears " + wordOccurrence + " time(s).");

    scanner.close();
  }
  
  private static int countWords(String text) {
    if (text == null || text.trim().isEmpty()) {
      return 0;
    }

    int count = 0;
    boolean isWord = false;
    int endOfLine = text.length() - 1;

    for (int i = 0; i < text.length(); i++) {
      if (Character.isLetterOrDigit(text.charAt(i)) && i != enfOfLine) {
        isWordj = true;
      }
      else if (!Character.isLetterOrDigit(text.chatAt(i)) && isWord) {
        count++;
        isWord = false;
      }
      else if (Character.isLetterOrDigit(text.charAt(i)) && i == endOfLine) {
        count++;
      }
    }
    return count;
  }

  private static int countSentences(String text) {
    if (text == null || text.isEmpty()) {
      return 0;
    }
    
    int count = 0;
    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);
      if (ch == '.' || ch == '!' || ch == '?') {
        count++;
      }
    }

    return count == 0 && text.trim().length() > 0 ? 1 : count;
  }

  private static void displayCharacterFrequency(String text) {
    int[] frequency = new int[256];

    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);

      if (ch != ' ' && ch < 256) {
        char lowerch = Character.toLowerCase(ch);
        frequency[lowerch]++;
      }
    }
    
    for (int i = 0; i < frequency.length(); i++) {
      if (frequency[i] > 0) {
        System.out.println("'" + (char) i + "' : " + frequency[i]);
      }
    }
  }

  private static int searchWord(String text, String target) {
    if (text == null || target == null || text.trim().isEmpty() || target.trim().isEmpty()) {
      return 0;
    }
  }
}
