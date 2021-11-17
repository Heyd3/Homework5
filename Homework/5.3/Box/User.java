package Box;

public class User {
    int a = 0;
    public static volatile int i = 0;

    public void pressing () {
        while (a != 5) {
            i++;
            System.out.println(i);
            a++;
            System.out.println(a);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
