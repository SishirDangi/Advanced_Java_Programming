// Class that implements the Runnable interface
class NumberPrinter implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                // Sleep for 2 seconds (2000 milliseconds)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
            }
        }
    }
}

class NumberPrinterDemo {
    public static void main(String[] args) {
        // Create an instance of NumberPrinter
        NumberPrinter numberPrinter = new NumberPrinter();

        // Create a thread with the Runnable object
        Thread thread = new Thread(numberPrinter);

        // Start the thread
        thread.start();

        // Wait for the thread to finish
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Printing Lab information
        System.out.println("\nQuestion No.: 13h");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
