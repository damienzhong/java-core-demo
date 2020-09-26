package multithreading;

public class ThreadExer {
    public static void main(String[] args) {
        SinglePrintThread singlePrintThread = new SinglePrintThread();
        singlePrintThread.setName("奇数线程");
        singlePrintThread.start();

        DoublePrintThread doublePrintThread = new DoublePrintThread();
        doublePrintThread.setName("偶数线程");
        doublePrintThread.start();

    }
}
