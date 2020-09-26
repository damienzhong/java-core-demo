package multithreading;

public class ThreadTest extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new ThreadTest().start();
        new ThreadTest().start();
    }
}
