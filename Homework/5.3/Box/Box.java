package Box;

public class Box {
    int a = 0;
    public static volatile int i = 0;

    public void pressing () {
        while (a != 5) {
            i++;
            System.out.println(i);
            a++;
            System.out.println("a = " + a);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void wringingOut (){

        while(a != 5){
            if (i==1) {
                i--;
                System.out.println(i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
