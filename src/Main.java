import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("gr1");

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
        group.interrupt();
    }
}
