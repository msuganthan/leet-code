package concurrency;

import java.util.concurrent.Semaphore;

public class PrintAlternate {

    Semaphore runf, runb;
    private final int n;

    public PrintAlternate(int n) {
        this.n = n;
        runf = new Semaphore(1);
        runb = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            runf.acquire();
            printFoo.run();
            runb.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            runb.acquire();
            printBar.run();
            runf.release();
        }
    }
}
