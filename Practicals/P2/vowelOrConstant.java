package Practicals.P2;

import java.util.Scanner;

public class vowelOrConstant {
    public static void main(String[] args) {
        // 5. Write a program that prompts user to enter a letter and check weather a letter is a vowel or constant.
        System.out.println("\n\n--- Checking Letter is Vowel or Constant ---");

        Scanner sc = new Scanner(System.in);
        char letter;
        System.out.print("Enter a letter: ");
        letter = sc.next().charAt(0); // taking input
        char letterLowerCase = Character.toLowerCase(letter); // lowering the case
        boolean isDigit = Character.isDigit(letter); // checking if the entered char is digit

        if (letterLowerCase == 'a' || letterLowerCase == 'e' || letterLowerCase == 'o' || letterLowerCase == 'u') {
            System.out.printf("The letter %c is Vowel!", letter);
        }
        else if(isDigit) {
            System.out.printf("The letter %c is a Digit!", letter);
        }
        else {
            System.out.printf("The letter %c is Constant!", letter);
        }

        sc.close();
    }
}
