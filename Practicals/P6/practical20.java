import ecom.Customer;
import ecom.Product;
import ecom.Order;

class practical20 {
  public static void main(String[] args) {
    Customer client = new Customer("customer1", "customer1@gmail.com");
    Product item = new Product("Wireless Earbuds", 2499.00);

    Order newOrder = new Order(55012, client, item, 2);

    newOrder.displayOrderSummary();
  }
}
