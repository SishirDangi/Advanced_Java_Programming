// Class that implements the Runnable interface
class MyRunnable implements Runnable {
    private String threadName;

    // Constructor to set thread name
    public MyRunnable(String threadName) {
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

class RunnableDemo {
    public static void main(String[] args) {
        // Create instances of MyRunnable for two threads
        MyRunnable runnable1 = new MyRunnable("Thread 1");
        MyRunnable runnable2 = new MyRunnable("Thread 2");

        // Create Thread objects and pass the Runnable instances
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        // Start the threads
        thread1.start();
        thread2.start();

        // Printing Lab information
        System.out.println("\nQuestion No.: 13a");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
