package util.elementUtils;

import org.openqa.selenium.WebElement;

public class UtilElements {
    public static Integer parseLowestPrice(WebElement productPriceRangePath) {
        return Integer.valueOf(productPriceRangePath.getText()
                .split("['...']")[0]
                .replaceAll("[^0-9]", ""));
    }
}
