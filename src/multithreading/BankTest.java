package multithreading;

public class BankTest {
    public static void main(String[] args) {
        BankRunnable bankRunnable = new BankRunnable();
        new Thread(bankRunnable).start();
        new Thread(bankRunnable).start();
    }
}

class BankRunnable implements Runnable {

    private int balance = 0;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            addMoney();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void addMoney() {
        this.balance += 1000;
        System.out.println(Thread.currentThread().getName() + "存入之后，当前账户余额：" + this.balance);
    }
}
