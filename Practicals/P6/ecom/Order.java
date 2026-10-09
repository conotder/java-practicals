package ecom;

public class Order {
  private int orderId;
  private Customer customer;
  private Product product;
  private int quantity;

  public Order(int orderId, Customer customer, Product product, int quantity) {
    this.orderId = orderId;
    this.customer = customer;
    this.product = product;
    this.quantity = quantity;
  }

  public void displayOrderSummary() {
    double totalCost = product.getPrice() * quantity;
    System.out.println("--- Order Details ---");
    System.out.println("Order ID    : #" + orderId);
    System.out.println("Customer    : " + customer.getName() + " (" + customer.getEmail() + ")");
    System.out.println("Item        : " + product.getProductName() + " x " + quantity);
    System.out.println("Total Bill  : ₹" + totalCost);
  }
}
