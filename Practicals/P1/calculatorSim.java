package Practicals.P1;

import java.util.Scanner;

class Calculate{
    public boolean isNextOperation(boolean nextOperation){
        System.out.print("Do you want to continue (y/n)? ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.equalsIgnoreCase("y")){
            nextOperation = true;
        }
        else if(input.equalsIgnoreCase("n")){
            nextOperation = false;
        }
        else{
            System.out.println("Invalid input! Run again.");
            nextOperation = false;
        }
        return nextOperation;
    }
}

public class calculatorSim {
    public static void main(String[] args) {
        // 3. Calculator simulation.
        System.out.println("--- Calculator Sim ---"); // Decoration.


        // variable declaration
        double number1, number2, result;
        boolean calculate = true;
        char operand;
        Scanner sc = new Scanner(System.in);

        // Checking if the users wants to calculate more
        Calculate calc = new Calculate();
        calculate = calc.isNextOperation(calculate);

        while (calculate) {
            // Looping calculate sim
            System.out.print("Enter the first number: ");
            number1 = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter the operation you want to perform number: ");
            operand = sc.nextLine().charAt(0);

            // Checking the operands
            if (operand == '+'){
                System.out.print("Enter the second number: ");
                number2 = sc.nextDouble();
                sc.nextLine();
                result = number1 + number2;
                System.out.println(number1 + " + " + number2 + " = " + result);
                calculate = calc.isNextOperation(calculate);
            }
            else if (operand == '-'){
                System.out.print("Enter the second number: ");
                number2 = sc.nextDouble();
                sc.nextLine();
                result = number1 - number2;
                System.out.println(number1 + " - " + number2 + " = " + result);
                calculate = calc.isNextOperation(calculate);
            }
            else if (operand == '*'){
                System.out.print("Enter the second number: ");
                number2 = sc.nextDouble();
                sc.nextLine();
                result = number1 * number2;
                System.out.println(number1 + " * " + number2 + " = " + result);
                calculate = calc.isNextOperation(calculate);
            }
            else if (operand == '/'){
                System.out.print("Enter the second number: ");
                number2 = sc.nextDouble();
                sc.nextLine();
                result = number1 / number2;
                System.out.println(number1 + " / " + number2 + " = " + result);
                calculate = calc.isNextOperation(calculate);
            }
            else {
                System.out.println("Invalid input");
            }
        }
        sc.close(); // Closing the Scanner class.

    }
}
