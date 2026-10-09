class baseBilling {

  public double calculateBill(double itemTotal) {
    double tax = itemTotal * 0.05;
    return itemTotal + tax;
  }

  public double calculateBill(double itemTotal, double discountPercent) {
    double discountAmount = itemTotal * (discountPercent / 100);
    double discountedTotal = itemTotal - discountAmount;
    double tax = discountAmount * 0.05;
    return discountedTotal + tax;
  }
}

class FineDinigBilling extends baseBilling {

  @Override
  public double calculateBill(double itemTotal) {
    double serviceCharge = itemTotal * 0.10;
    double subTotal = itemTotal + serviceCharge;
    double tax = subTotal * 0.05;
    return subTotal + tax;
  }
}

class practical18 {
  public static void main(String[] args) {
    baseBilling regularBill = new baseBilling();
    System.out.println("---Standard Billing ---");
    System.out.println("Normal Bill Total: ₹" + regularBill.calculateBill(500.0));
    System.out.println("Bill Total with 10% Coupon: ₹" + regularBill.calculateBill(500.0, 10.0));

    System.out.println("\n--- Fine Dining Luxury Resturant Billing ---");
    baseBilling luxuryBill = new FineDinigBilling();
    System.out.println("Fine Dining Bill (Includes 10% service charge): " + luxuryBill.calculateBill(500.0));
  }
}
