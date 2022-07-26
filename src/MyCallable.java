import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private String name;

    protected MyCallable setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Integer call() {
        Thread.currentThread().setName(name);

        int count = 0;

        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(3000);
                System.out.printf("Я %s. Всем привет!\n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            count++;
        }
        return count;
    }
}
