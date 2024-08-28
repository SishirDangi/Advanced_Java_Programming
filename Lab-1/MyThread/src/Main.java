// Class that extends the Thread class
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

class ThreadDemo {
    public static void main(String[] args) {
        // Create instances of MyThread for two threads
        MyThread thread1 = new MyThread("Thread 1");
        MyThread thread2 = new MyThread("Thread 2");

        // Start the threads
        thread1.start();
        thread2.start();

        // Printing Lab information
        System.out.println("\nQuestion No.: 13b");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
