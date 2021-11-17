package Tax;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService1 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService2 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService3 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        LongAdder stat = new LongAdder();
        IntStream.range(0, 5).forEach(i -> executorService1.submit(() -> stat.add(i)));
        IntStream.range(0, 5).forEach(i -> executorService2.submit(() -> stat.add(i)));
        IntStream.range(0, 5).forEach(i -> executorService3.submit(() -> stat.add(i)));

        executorService1.awaitTermination(3, TimeUnit.SECONDS);
        executorService2.awaitTermination(3, TimeUnit.SECONDS);
        executorService3.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("\nРезультат: " + stat.sum());
        executorService1.shutdown();
        executorService2.shutdown();
        executorService3.shutdown();

    }
}
