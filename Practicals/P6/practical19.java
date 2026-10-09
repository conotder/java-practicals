interface Polygon {
  double calculateArea();
  double calculatePerimeter();
  void displayValues();
}

class Square implements Polygon {
  private double side;

  public Square(double side) {
    this.side = side;
  }

  public double calculateArea() {
    return side * side;
  }

  public double calculatePerimeter() {
    return 4 * side;
  }

  public void displayValues() {
    System.out.println("--- Square Properties ---");
    System.out.println("Side Length: " + side);
    System.out.println("Area: " + calculateArea());
    System.out.println("Perimeter: " + calculatePerimeter());
  }
}

class Rectangle implements Polygon {
  private double length;
  private double width;

  public Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  public double calculateArea() {
    return length * width;
  }

  public double calculatePerimeter() {
    return 2 * (length + width);
  }

  public void displayValues() {
    System.out.println("--- Rectangle Properties ---");
    System.out.println("Length: " + length + ", Width: " + width);
    System.out.println("Area: " + calculateArea());
    System.out.println("Perimeter: " + calculatePerimeter());
  }
}

class practical19 {
  public static void main(String[] args) {
    Polygon square = new Square(5.0);
    Polygon rectangle = new Rectangle(6.0, 4.0);

    square.displayValues();
    System.out.println();
    rectangle.displayValues();
  }
}
