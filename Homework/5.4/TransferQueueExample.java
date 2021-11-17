package CallCenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TransferQueueExample {
    TransferQueue<String> queue = null;

    String WAIT_producer = "Входящий звонок : "; //Producer waiting to transfer
    String TRANSFERED = "Звонок ";

    String WAIT_consumer = "Свободен ";
    String CONSUMED = "Звонок принят : ";

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public TransferQueueExample() {
        queue = new LinkedTransferQueue<String>();
        final Producer producer = new Producer();
        final Consumer consumer = new Consumer();

        new Thread(null, producer::run, "Звонящий ").start();
        new Thread(null, consumer::run, "Оператор 1 ").start();
        new Thread(null, consumer::run, "Оператор 2 ").start();
        new Thread(null, consumer::run, "Оператор 3 ").start();
    }

    void printMessage(final String msg) {
        String text = sdf.format(new Date()) + " " + msg;
        System.out.println(text);
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 15; i++) {
                try {
                    printMessage(WAIT_producer + (i + 1));
                    queue.transfer(WAIT_producer + (i + 1));
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            do {
                try {
                    printMessage(WAIT_consumer + Thread.currentThread().getName());
                    String element = queue.take();
                    printMessage(CONSUMED + Thread.currentThread().getName());
                    Thread.sleep(3000);
                } catch (Exception e) {
                }

            } while ((!queue.isEmpty()));
        }
    }


    public static void main(String args[]) {
        new TransferQueueExample();
    }
}
