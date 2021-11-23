package Box;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        final Box box = new Box();
        new Thread(null, box::pressing, "Пользователь").start();
        new Thread(null, box::wringingOut, "Пользователь").start();
    }
}
