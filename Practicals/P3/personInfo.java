package Practicals.P3;

class Person{
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class personInfo {
    public static void main(String[] args) {
        // Write a Java program that displays person's name and age using a person class and parameterized constructor.
        Person person1 = new Person("Patrick Jane", 40);
        Person person2 = new Person("Teressa Lisbon", 35);

        person1.displayInfo();
        person2.displayInfo();
    }
}
