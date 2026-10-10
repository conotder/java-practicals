class InvalidNumberException extends Exception {
  public InvalidNumberException(String message) {
    super(message);
  }
}

class DivisionByZeroException extends Exception {
  public DivisionByZeroException(String message) {
    super(message);
  }
}

class MathFunctions {
  public double calculateMean(double[] numbers) throws InvalidNumberException {
    if (numbers == null || numbers.length == 0) {
      throw new InvalidNumberException("Array connot be null or empty.")
    }

    double sum = 0;
    for (double num: numbers) {
      if (num < 0){
        throws new InvalidNumberException("Negaive numbers are not allowed: " + num);
      }
      sum += num;
    }
    return sum / numbers.length;
  }

  public double divide(double dividend, double divisor) throws DivisionByZeroException {
    if (divisor == 0) {
      throw new DivisionByZeroException("Cannot divide by zero.")
    }
    return dividend / divisor;
  }
}

class practical26 {
  public static void main(String[] args) {
    MathFunctions math = new MathFunctions();

    System.out.println("--- Testing Division ---");
    try {
      System.out.println("Result (10 / 2): " + math.division(10,2));
      System.out.println("Result (10 / 0): " + math.division(10,0));
    }
    catch (DivisionByZeroException e){
      System.out.println("Exception caught: " e.getMessage());
    }

    System.out.println("--- Testing Mean Calculation");
    try {
      double[] validNumbers = {4.5, 5.5, 8.0}
      System.out.println("Mean of valid numbers: " + math.calculateMean(validNumbers));

      double[] invalidNumber = {4.5 -2.0 , 8.0};
      System.out.println("Mean of invalid numbers: " + math.calculateMean(invalidNumber));
    }
    catch (InvalidNumberException e) {
      System.out.println("Exception caught: "e.getMessage());
    }
  }
}
