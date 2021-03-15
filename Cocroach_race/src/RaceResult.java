public class RaceResult {

    private final String name;

    private final long raceTime;

    public RaceResult(String name, long raceTime) {
        this.name = name;
        this.raceTime = raceTime;
    }

    public String getName() {
        return name;
    }

    public long getRaceTime() {
        return raceTime;
    }

    @Override
    public String toString() {
        return "RaceResult {" +
                "name = '" + name + '\'' +
                ", raceTime = " + raceTime + " seconds" +
                '}';
    }
}

