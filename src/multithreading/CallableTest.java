package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        CallableThread callableThread = new CallableThread();
        FutureTask futureTask = new FutureTask<>(callableThread);
        new Thread(futureTask).start();

        try {
            int sum = (int) futureTask.get();
            System.out.println(Thread.currentThread().getName() + "累加总数为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallableThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "当前累加数为：" + i);
                sum += i;
            }
        }
        return sum;
    }
}