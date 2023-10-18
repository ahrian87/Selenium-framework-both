package waits;

public class OtherWaits {

    public static void waitForXSeconds(String x) throws InterruptedException {
        Thread.sleep(Integer.parseInt(x) * 1000);
    }
}
