import java.util.ArrayList;
import java.util.List;

public class Race {

    public static void main(String[] args) throws InterruptedException {
        int stepsQuantity = 10;
        int pauseTime = 500;
        int threadsQuantity = 5;

        List<RaceResult> resultList = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadsQuantity; i++) {
            Thread thread = new Thread(new Cockroach("Cockroach-" + i, stepsQuantity, pauseTime, resultList));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (RaceResult res : resultList) {
            System.out.println(res);

        }
    }
}
