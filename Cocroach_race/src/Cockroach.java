import java.util.List;
import java.util.Random;

public class Cockroach implements Runnable {

    private final String name;
    private final int stepsQuantity;
    private final int pauseTime;
    private final List<RaceResult> resultList;

    public Cockroach(String name, int stepsQuantity, int pauseTime, List<RaceResult> resultList) {
        this.name = name;
        this.stepsQuantity = stepsQuantity;
        this.pauseTime = pauseTime;
        this.resultList = resultList;
    }

    Random random = new Random();

    public String getName() {
        return name;
    }

    public int getStepsQuantity() {
        return stepsQuantity;
    }

    public int getPauseTime() {
        return pauseTime;
    }

    public List<RaceResult> getResultList() {
        return resultList;
    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();

        for (int i = 0; i < stepsQuantity; i++) {
            try {
                Thread.sleep(getRandomNumber(1, pauseTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();

        long raceTime = (end - start) / 1000;

        synchronized (resultList) {
            resultList.add(new RaceResult(name, raceTime));
        }
    }

    private Integer getRandomNumber(int min, int max) {
        return min + random.nextInt(max) + 1;
    }

    @Override
    public String toString() {
        return "Cockroach{" +
                "name='" + name + '\'' +
                '}';
    }
}
