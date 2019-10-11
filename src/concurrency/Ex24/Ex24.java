package concurrency.Ex24;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex24 {
    private final Producer producer;
    private final Consumer consumer;
    private int buffer = -1;
    private ExecutorService executorService = Executors.newCachedThreadPool();

    private Ex24() {
        this.producer = new Producer(this);
        this.consumer = new Consumer(this);
        executorService.execute(producer);
        executorService.execute(consumer);
    }

    public static void main(String[] args) {
        new Ex24();
    }

    private static class Producer implements Runnable {
        private int data = -1;
        private Ex24 b;

        Producer(Ex24 b) {
            this.b = b;
        }

        @Override public void run() {
            while (!Thread.interrupted()) {
                try {
                    synchronized (this) {
                        while (b.buffer != -1) {
                            wait();
                        }
                    }
                    TimeUnit.SECONDS.sleep(2);
                    synchronized (b.consumer) {
                        data++;
                        b.buffer = data;
                        b.consumer.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        int buffer = -1;
        private Ex24 b;

        Consumer(Ex24 b) {
            this.b = b;
        }

        @Override public void run() {
            try {
                while (!Thread.interrupted()) {
                    synchronized (this) {
                        while (buffer == b.buffer) {
                            wait();
                        }
                    }
                    System.out.println(b.buffer + " received by consumer");
                    synchronized (b.producer) {
                        b.buffer = -1;
                        b.producer.notify();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted consumer task");
            }
        }
    }
}
