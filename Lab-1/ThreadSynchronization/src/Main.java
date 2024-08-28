// Class that extends Thread
class Counter extends Thread {
    private static int count = 0;

    // Synchronized method to increment the counter
    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
    }

    @Override
    public void run() {
        // Call the synchronized method multiple times
        for (int i = 0; i < 5; i++) {
            increment();
            try {
                // Sleep for 100 milliseconds
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }
        }
    }
}

class ThreadSynchronization {
    public static void main(String[] args) {
        // Create instances of Counter thread
        Counter thread1 = new Counter();
        Counter thread2 = new Counter();

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Printing Lab information
        System.out.println("\nQuestion No.: 13e");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
