import java.util.Scanner;

public class practical13new {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Paragraph Analyzer");
        System.out.println("Please enter or paste your paragraph below:");
        String paragraph = scanner.nextLine().trim();

        if (paragraph.isEmpty()) {
            System.out.println("The paragraph is empty. Exiting program.");
            scanner.close();
            return;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Choose an Operation ---");
            System.out.println("1. Count Words and Sentences");
            System.out.println("2. Display Character Frequency");
            System.out.println("3. Search for a Word");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    countWordsAndSentences(paragraph);
                    break;
                case 2:
                    displayCharacterFrequency(paragraph);
                    break;
                case 3:
                    System.out.print("Enter the word you want to search for: ");
                    String searchWord = scanner.next();
                    scanner.nextLine();
                    searchWord(paragraph, searchWord);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 4.");
            }
        }
        scanner.close();
    }

    private static void countWordsAndSentences(String text) {

        String[] words = text.split("\\s+");
        int wordCount = text.isEmpty() ? 0 : words.length;


        int sentenceCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '.' || ch == '!' || ch == '?') {
                sentenceCount++;

                while (i + 1 < text.length() && (text.charAt(i + 1) == '.' || text.charAt(i + 1) == '!' || text.charAt(i + 1) == '?')) {
                    i++;
                }
            }
        }


        if (sentenceCount == 0 && !text.isEmpty()) {
            sentenceCount = 1;
        }

        System.out.println("\n--- Results ---");
        System.out.println("Total Words: " + wordCount);
        System.out.println("Total Sentences: " + sentenceCount);
    }


    private static void displayCharacterFrequency(String text) {

        int[] frequency = new int[256];
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            if (ch != ' ' && ch != '\t' && ch != '\n' && ch != '\r') {
                frequency[ch]++;
            }
        }

        System.out.println("\n--- Character Frequency (Case-Insensitive) ---");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("'" + (char) i + "' : " + frequency[i]);
            }
        }
    }

    private static void searchWord(String text, String target) {

        String cleanText = text.replaceAll("[.,!?\\\"';:]", "");
        String[] words = cleanText.split("\\s+");

        int count = 0;
        for (String word : words) {

            if (word.equalsIgnoreCase(target)) {
                count++;
            }
        }

        System.out.println("\n--- Word Search Results ---");
        if (count > 0) {
            System.out.println("The word \"" + target + "\" was found " + count + " time(s).");
        } else {
            System.out.println("The word \"" + target + "\" was not found in the paragraph.");
        }
    }
}

