import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaceWithExecutorService {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        int stepsQuantity = 10;
        int pauseTime = 500;
        int threadsQuantity = 5;

        List<RaceResult> resultList = new ArrayList<>();

        for (int i = 0; i < threadsQuantity; i++) {
            executorService.execute(new Cockroach("Cockroach-" + i, stepsQuantity, pauseTime, resultList));
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        for (RaceResult res : resultList) {
            System.out.println(res);

        }
    }
}
