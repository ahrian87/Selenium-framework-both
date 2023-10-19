package waits;

public class OtherWaits {

    public static void waitForXSeconds(String x) {
        try {
            Thread.sleep(Integer.parseInt(x) * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
