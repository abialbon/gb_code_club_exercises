public class StopClock {
    private double now;

    StopClock() {
        now = System.currentTimeMillis();
    }

    public double getElapsedTime() {
        double end = System.currentTimeMillis();
        return end - now;
    }
}
