// Class that extends Thread to create a custom thread
class CountdownThread extends Thread {
    @Override
    public void run() {
        for (int i = 100; i >= 1; i--) {
            System.out.print(i);
            System.out.print("\t");
            try {
                // Sleep for 3 seconds (3000 milliseconds)
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
            }
        }
    }
}

class CountdownDemo {
    public static void main(String[] args) {
        // Create an instance of CountdownThread
        CountdownThread countdownThread = new CountdownThread();

        // Start the thread
        countdownThread.start();

        // Wait for the thread to finish
        try {
            countdownThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Printing Lab information
        System.out.println("\nQuestion No.: 13g");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
