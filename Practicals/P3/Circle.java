package Practicals.P3;

import java.util.Scanner;

class Area{
    public double areaCircle(double radius){
        return Math.PI * radius * radius;
    }
}

public class Circle {
    public static void main(String[] args){
        // Write a program to display area of circle by creating Area class and areaCircle method.

        Scanner sc = new Scanner(System.in);
        double radius;
        System.out.print("Enter the radius of the circle: ");
        radius = sc.nextDouble();
        Area area = new Area();
        System.out.printf("Area of Circle: %.2f%n", area.areaCircle(radius));

    }
}
