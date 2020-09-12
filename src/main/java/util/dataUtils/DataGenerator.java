package util.dataUtils;

public class DataGenerator {

    public static int intGenerator(int start, int numbers) {
        return (int) ((Math.random() * (numbers - start)) + start);
    }

    public static int intGenerator(int length) {
        return (int) (Math.random() * length);
    }

    private static String simpleStringGenerator(String charset, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(charset.charAt(intGenerator(charset.length())));
        return sb.toString();
    }

    public static String loginGenerator() {
        return simpleStringGenerator(CharDataForTestSite.EMAIL_SYMBOLS, intGenerator(4, 20));
    }

    public static String passGenerator() {
        return simpleStringGenerator(CharDataForTestSite.EMAIL_SYMBOLS, intGenerator(6, 20));
    }
}
