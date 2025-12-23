import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
    private Queue<Integer> queue;
    private Random random;

    public CarQueue() {
        queue = new ArrayDeque<>();
        random = new Random();

        for (int i = 0; i < 6; i++) {
            queue.add(random.nextInt(4));
        }
    }

    public void addToQueue() {
        class QueueRunnable implements Runnable {
            public void run() {
                try {
                    while (true) {
                        synchronized (queue) {
                            queue.add(random.nextInt(4));
                        }
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                }
            }
        }
        Runnable r = new QueueRunnable();
        Thread t = new Thread(r);
        t.start();
    }

    public Integer deleteQueue() {
        synchronized (queue) {
            if (queue.isEmpty()) {
                return random.nextInt(4);
            }
            return queue.remove();
        }
    }
}