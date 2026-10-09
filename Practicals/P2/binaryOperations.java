package Practicals.P2;

import java.util.Scanner;

public class binaryOperations {
    public static void main(String[] args) {
        // 4. Write a Java program that makes an array of 4-bit binary to visually represent numbers 0-15 in binary. Take any two integer, perform operators and print the result.
        String[] binaryLookup = new String[16]; // array of string that stores binary
        for (int i = 0; i < binaryLookup.length; i++) {
            String binaryStr = Integer.toBinaryString(i); //converting integer values into binary from 0 to 15
            binaryLookup[i] = String.format("%4s", binaryStr).replace(' ', '0'); // making them 4 digit and storing into array.
        }

        System.out.println("--- 4-Bit Binary Representations (0-15) ---"); // just for decoration..
        System.out.println("Dec | Binary");
        System.out.println("----|-------");

        // printing all decimals and binaries from 0 to 15
        for (int i = 0; i < binaryLookup.length; i++) {
            System.out.printf("%2d  | %s\n", i, binaryLookup[i]);
        }

        System.out.println("----------\n"); // decoration..

        // taking 2 inputs
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first integer (0-15): ");
        int a = sc.nextInt();
        System.out.print("Enter second integer (0-15): ");
        int b = sc.nextInt();

        // validating inputs
        if (a < 0 || a > 15 || b < 0 || b > 15) {
            System.out.println("Please run the program again and enter numbers between 0 and 15");
            return;
        }

        System.out.println("\n--- Performing Operations ---"); // decoration..
        System.out.printf("Num1: %d (%s)\n", a, binaryLookup[a]); // printing chosen number1
        System.out.printf("Num2: %d (%s)\n", b, binaryLookup[b]); // printing chosen number2

        // Performing all the operation of Math.
        int andResult = a & b;
        System.out.printf("Bitwise And (&) : %d (%s)\n", andResult, binaryLookup[andResult]);

        int orResult = a | b;
        System.out.printf("Bitwise Or (|) : %d (%s)\n", orResult, binaryLookup[orResult]);

        int xorResult = a ^ b;
        System.out.printf("Bitwise xor (^) : %d (%S)\n", xorResult, binaryLookup[xorResult]);

        int sumResult = a + b;
        if (sumResult <= 15) {
            System.out.printf("Addition (+): %d (%s)\n", sumResult, binaryLookup[sumResult]);
        }
        else{
            System.out.printf("Addition (+): %d (Binary exceeds 4 bits: %s)\n", sumResult, Integer.toBinaryString(sumResult));
        }

        sc.close(); // Closing Scanner class
    }
}
