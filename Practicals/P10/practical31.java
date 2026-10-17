class practical31 {
  public static void main(String[] args) {
    Thread lowPriorityThread = new Thread(new CpuTask(), "Low-Priority-Thread");
    Thread maxPriorityThread = new Thread(new CpuTask(), "Max-Priority-Thread");

    lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
    maxPriorityThread.setPriority(Thread.MAX_PRIORITY);

    System.out.println("Starting threads. High priority should finish faster or process more data...");
    lowPriorityThread.start();
    maxPriorityThread.start();
  }
}

class CpuTask implements Runnable {
  public void run() {
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    long count = 0;
    for(long i = 2; i < 300000; i++) {
      if (isPrime(i)) {
        count++;
      }
    }

    long endTime = System.currentTimeMillis();
    System.out.println(threadName + " finished. Total primes Found: " + count + " | Time taken: " + (endTime - startTime) + " ms");
  }

  private boolean isPrime(long num) {
    if (num <= 1) return false;
    for (long i = 2; i * i <= num; i++) {
      if (num % i == 0) return  false;
    }
    return true;
  }
}
