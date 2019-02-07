package concurrency.Ex20;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CachedThreadPoolInterrupted {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            futures.add(exec.submit(new LiftOff(10)));
        for (Future future: futures) {
            future.cancel(true);
        }

        exec.shutdown();
    }
}
