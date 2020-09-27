package multithreading;

public class WindowsTest {

    public static void main(String[] args) {
        new Windows().start();
        new Windows().start();
        new Windows().start();
    }


}

class Windows extends Thread {
    public static int tiketNum = 100;

    @Override
    public void run() {
        while (tiketNum > 0) {
            tiketNum--;
            System.out.println(getName() + "--剩余票数：" + tiketNum);
        }
    }
}