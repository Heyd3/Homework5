package Tax;

import java.util.concurrent.atomic.AtomicLongArray;

public class Account {
    AtomicLongArray money = new AtomicLongArray(10);
    public void transfer(long[] diff) {

        long result = 0;
        for (int i = 0; i < diff.length; i++) {
            System.out.printf("%s переводитвам %d рублей\n", Thread.currentThread().getName(), diff[i]);
            result = result + money.addAndGet(i+1, diff[i]);
        }
    }
    public long getCurrent() {
        long a = 0;
        for (int i = 0; i < money.length(); i++){
            a = a + money.get(i);
        }
        return a;
    }
}
