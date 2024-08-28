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
        System.out.println(threadName + " with priority " + getPriority() + " is running.");
    }
}
class ThreadPriorityDemo {
    public static void main(String[] args) {
        // Create thread instances
        MyThread thread1 = new MyThread("Thread 1");
        MyThread thread2 = new MyThread("Thread 2");
        MyThread thread3 = new MyThread("Thread 3");

        // Set thread priorities
        thread1.setPriority(Thread.MIN_PRIORITY); // 1
        thread2.setPriority(Thread.NORM_PRIORITY); // 5
        thread3.setPriority(Thread.MAX_PRIORITY); // 10

        // Print thread priorities and start threads
        System.out.println("Thread 1 priority: " + thread1.getPriority());
        System.out.println("Thread 2 priority: " + thread2.getPriority());
        System.out.println("Thread 3 priority: " + thread3.getPriority());

        thread1.start();
        thread2.start();
        thread3.start();

        // Printing Lab information
        System.out.println("\nQuestion No.: 13d");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
