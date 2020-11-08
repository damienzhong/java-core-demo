package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 开启三个线程，这三个线程的ID分别为A、B、C，每个线程将自己的ID在屏幕上打印10遍，要求输出的结果必须按顺序显示。
 * 如ABCABCABC...依次递归
 */
public class TestABCIterate {
    public static void main(String[] args) throws InterruptedException {
        ABCIterateThread abcIterateThread = new ABCIterateThread();
        Thread thread = new Thread(abcIterateThread);
        thread.setName("A");
        thread.start();
        Thread thread2 = new Thread(abcIterateThread);
        thread2.setName("B");
        thread2.start();
        Thread thread3 = new Thread(abcIterateThread);
        thread3.setName("C");
        thread3.start();
    }
}

class ABCIterateThread implements Runnable {

    private volatile int mark = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private Condition condition4 = lock.newCondition();

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                boolean flag = true;
                while (flag) {
                    if (mark == 1 && "A".equals(Thread.currentThread().getName())) {
                        System.out.print(Thread.currentThread().getName());
                        mark = 2;
                        flag = false;
                        condition2.signal();
                        condition4.signal();
                        condition.await();
                    } else if (mark == 2 && "B".equals(Thread.currentThread().getName())) {
                        System.out.print(Thread.currentThread().getName());
                        mark = 3;
                        flag = false;
                        condition3.signal();
                        condition4.signal();
                        condition2.await();
                    } else if (mark == 3 && "C".equals(Thread.currentThread().getName())) {
                        System.out.print(Thread.currentThread().getName());
                        mark = 1;
                        flag = false;
                        condition.signal();
                        condition4.signal();
                        condition3.await();
                    } else {
                        condition4.await();
                    }

                    if (i == 9) {
                        flag = false;
                        condition.signal();
                        condition2.signal();
                        condition3.signal();
                        condition4.signal();
                    }
                }
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}
