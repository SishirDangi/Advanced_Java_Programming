// Class that extends Thread
class MyThread extends Thread {
    private String threadName;

    // Constructor to set thread name
    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    // The run method contains the code that will be executed by the thread
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " is running - Count: " + i);
            try {
                // Sleep for 500 milliseconds
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
        System.out.println(threadName + " has finished execution.");
    }
}

class ThreadMethodsDemo {
    public static void main(String[] args) {
        // Create instances of MyThread
        MyThread thread1 = new MyThread("Thread 1");
        MyThread thread2 = new MyThread("Thread 2");

        // Start the threads
        thread1.start();
        thread2.start();

        // Check if the threads are alive before calling join()
        System.out.println("Thread 1 is alive: " + thread1.isAlive());
        System.out.println("Thread 2 is alive: " + thread2.isAlive());

        try {
            // Wait for thread1 to finish
            thread1.join();
            System.out.println("Thread 1 has joined.");

            // Wait for thread2 to finish
            thread2.join();
            System.out.println("Thread 2 has joined.");
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Check if the threads are alive after calling join()
        System.out.println("Thread 1 is alive after join: " + thread1.isAlive());
        System.out.println("Thread 2 is alive after join: " + thread2.isAlive());

        // Additional code after threads have finished
        System.out.println("Both threads have completed execution.");

        // Printing Lab information
        System.out.println("\nQuestion No.: 13c");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
