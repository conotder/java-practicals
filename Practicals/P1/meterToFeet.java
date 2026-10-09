package Practicals.P1;

import java.util.Scanner;

public class meterToFeet {
    public static void main(String[] args) {
        // 2. Input number as meters, convert to feet and display the results.
        // creating scanner to take input.
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- Meter to Feet Conversion ---");
        System.out.print("Enter the Meters: ");
        double meters = sc.nextDouble();
        double feet = (meters * 3.28);
        System.out.println(meters + " meter = " + feet + " feet");

        sc.close();
    }
}
