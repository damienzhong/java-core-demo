package multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁统计所有线程耗时
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        CountDownLatchThread countDownLatchThread = new CountDownLatchThread(countDownLatch);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(countDownLatchThread).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}

class CountDownLatchThread implements Runnable {

    private CountDownLatch countDownLatch;

    public CountDownLatchThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        synchronized (countDownLatch){
            long start = System.currentTimeMillis();
            try {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        Thread.sleep(10);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
            long end = System.currentTimeMillis();
            System.out.println((end - start) + Thread.currentThread().getName());
        }
    }
}
