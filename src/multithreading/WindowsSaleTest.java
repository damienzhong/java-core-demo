package multithreading;

public class WindowsSaleTest {
    public static void main(String[] args) {
        SaleThread saleThread = new SaleThread();
        new Thread(saleThread).start();
        new Thread(saleThread).start();
        new Thread(saleThread).start();

    }
}

class SaleThread implements Runnable{
    private int ticketNum = 100;

    @Override
    public void run() {
        while (ticketNum > 0){
            ticketNum--;
            System.out.println(Thread.currentThread().getName() + "剩余门票="+ticketNum);
        }
    }
}