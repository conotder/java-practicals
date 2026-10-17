class practical30 {
  private final int limit = 20;
  private int count = 1;
  private boolean isOddTurn = true;

  public static void main(String[] args) {
    practical30 printer = new practical30();

    Thread oddThread = new Thread(() -> printer.printOdd());
    Thread evenThread = new Thread(() -> printer.printEven());

    oddThread.start();
    evenThread.start();
  }

  public void printOdd() {
    synchronized (this) {
      while (count <= limit) {
        while (!isOddTurn) {
          try {
            wait();
          }
          catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        }
        if (count <= limit) {
          System.out.println(Thread.currentThread().getName() + " (Odd) : " + count);
          count++;
        }
        isOddTurn = false;
        notifyAll();
      }
    }
  }

  public void printEven() {
    synchronized (this) {
      while (count <= limit) {
        while (isOddTurn) {
          try {
            wait();
          }
          catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        }
        if (count <= limit) {
          System.out.println(Thread.currentThread().getName() + " (Even): " + count);
          count++;
        }
        isOddTurn = true;
        notifyAll();
      }
    }
  }
}
