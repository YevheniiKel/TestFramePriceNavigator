package utils.dataUtils;

public class StringParsers {

    public static String formatToFileName(String scenarioName){
        return scenarioName.replaceAll("[^a-zA-Z0-9']", "_");
    }
}
