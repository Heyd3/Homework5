package Box;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        final User user = new User();
        final Toy toy = new Toy();
        new Thread(null, user::pressing, "Пользователь").start();
        new Thread(null, toy::wringingOut, "Пользователь").start();
    }
}
