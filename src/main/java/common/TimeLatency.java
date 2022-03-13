package common;

public final class TimeLatency {

    private TimeLatency() {}

    public static void simulateLatency(final long latency) {
        try {
            Thread.sleep(latency);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}
