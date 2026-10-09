class Car {
  static int totalCars = 0;
  static String[] allModelNames = new String[100];
  String modelName;

  public Car(String name){
    this.modelName = name;
    allModelNames[totalCars] = name;
    totalCars++;
  }

  public static void displayCarStatus() {
    System.out.println("Total Cars Created: " + totalCars);
    System.out.println("Model name of all cars created: ");
    for (int i = 0; i < totalCars; i++) {
      System.out.println("- " + allModelNames[i]);
    }
  }
}

class practical15 {
  public static void main(String[] args) {
    Car car1 = new Car("Ford Mustang");
    Car car2 = new Car("Omni");
    Car car3 = new Car("BMW GT 4");
    Car car4 = new Car("Rolls Royce");

    Car.displayCarStatus();
  }
}
