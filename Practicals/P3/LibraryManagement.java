package Practicals.P3;

class Book{
    String name;
    double price;

    Book(String name,double price){
        this.name=name;
        this.price=price;
    }

    void displayInfo(){
        System.out.println("Title: "+name);
        System.out.println("Price: $"+price);
    }
}


public class LibraryManagement {
    public static void main(String[] args) {
        // Write a Java program that displays book title and pricing using this keyword.
        Book book1 = new Book("Book1",50.00);
        Book book2 = new Book("Book2",50.00);
        Book book3 = new Book("Book3",50.00);
        Book book4 = new Book("Book4",50.00);
        Book book5 = new Book("Book5",50.00);
        Book book6 = new Book("Book6",50.00);

        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();
        book4.displayInfo();
        book5.displayInfo();
        book6.displayInfo();


    }
}
