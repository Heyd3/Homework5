package Tax;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long[] diff1 = new long[]{2,3,4};
        long[] diff2 = new long[]{20,30,40};
        long[] diff3 = new long[]{200,300,400};

        Account account = new Account();
        Thread thread1 = new Thread(null, () -> account.transfer(diff1), "Клиент 1");
        Thread thread2 = new Thread(null, () -> account.transfer(diff2), "Клиент 2");
        Thread thread3 = new Thread(null, () -> account.transfer(diff3), "Клиент 3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread3.join();
        thread2.join();
        thread1.join();
        System.out.println("\nБаланспослевсехпереводов: " + account.getCurrent());
    }
}
