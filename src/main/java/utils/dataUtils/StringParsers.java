package utils.dataUtils;

public class StringParsers {

    public static String formatToFileName(String scenarioName){
        System.out.println(scenarioName+"before");
        return scenarioName.replaceAll("[^a-zA-Z0-9']", "_");
    }
}
