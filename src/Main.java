import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
/*        ThreadGroup group = new ThreadGroup("gr1");

        List<Thread> threads = new ArrayList<>();

        var count = 4;

        for (int i = 0; i < count; i++) {
            threads.add(new MyThread(group, "поток " + i));
        }

        for (int i = 0; i < count; i++) {
            threads.get(i).start();
        }

        Thread.sleep(15000);
        System.out.println("Завершаю все потоки.");
        group.interrupt();*/


        var count = 4;
        List<Callable<Integer>> tasks = new ArrayList<>();
        ExecutorService threatPool = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            tasks.add(new MyCallable().setName("поток " + i));
        }

        for (Future<Integer> future :
                threatPool.invokeAll(tasks)) {
            System.out.println("Invoke all: " + future.get());
        }

        System.out.println("Invoke any: " + threatPool.invokeAny(tasks));
        threatPool.shutdown();
    }
}
