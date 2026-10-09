package Practicals.P2;

public class cmdLineArgument {
    public static void main(String[] args) {
        // 6. Write a Java program to test the command line argument. Display total number of argument and display one argument in one line.
        // commands:
        // javac cmdLineArgument.java
        // java cmdLineArgument Hello 1234 Bye AgainHello 4567 ByeBye
        System.out.println("Total Number of Argument: " + args.length);
        for (int i = 0; i < args.length; i++){
            System.out.println("Argument " + ( i ) + ": " + args[i]);
        }
    }
}
