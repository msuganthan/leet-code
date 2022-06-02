package evertz;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {

        IncrementCounter incrementCounter = new IncrementCounter();
        Thread t1 = new IncrementThread(incrementCounter);
        Thread t2 = new IncrementThread(incrementCounter);

        t1.start();
        t2.start();

        Thread t3 = new DisplayThread(incrementCounter);
        t3.start();
    }

    static class IncrementThread extends Thread {
        IncrementCounter counter;
        public IncrementThread(IncrementCounter counter) {
            this.counter = counter;
        }
        @Override
        public void run() {
            while (true) {
                this.counter.increment();
            }
        }
    }

    static class DisplayThread extends Thread {
        IncrementCounter counter;
        public DisplayThread(IncrementCounter counter) {
            this.counter = counter;
        }
        @Override
        public void run() {
            while (true) {
                this.counter.display();
            }
        }
    }


    static class IncrementCounter {
        private Integer counter = 0;

        public synchronized void increment() {
            this.counter += 1;
        }

        public synchronized void display() {
            System.out.println("counter value ==> "+counter);
        }
    }
}
