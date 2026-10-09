package Practicals.P3;

import java.util.Scanner;

public class Fibonacci {

    static int fibonacci(int n)
    {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        //Write a Java program to print Fibonacci series using a recursion function.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many numbers you want to print in Fibonacci series: ");
        int n = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

    }
}
