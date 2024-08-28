// Class that extends Thread
class Counter extends Thread {
    private static int count = 0;
    private static final Object lock = new Object();

    private String threadName;

    public Counter(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        // Synchronized block
        for (int i = 0; i < 5; i++) {
            synchronized (lock) {
                count++;
                System.out.println(threadName + " incremented count to: " + count);
            }
            try {
                // Sleep for 100 milliseconds
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
    }
}

class ThreadSynchronizationDemo {
    public static void main(String[] args) {
        // Create instances of Counter thread
        Counter thread1 = new Counter("Thread 1");
        Counter thread2 = new Counter("Thread 2");

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
        System.out.println("\nQuestion No.: 13f");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
