package util.elementUtils;

public class WaitUtils {

    public static void sleepSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
