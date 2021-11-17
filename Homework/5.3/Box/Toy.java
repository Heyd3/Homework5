package Box;

public class Toy {
     int i = 0;
    public void wringingOut (){

        while(User.i==1){
            User.i--;
            System.out.println(i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
