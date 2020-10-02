package dto;

import java.util.List;

public class ProductDto {

    private Integer lowestPrice;
    private String name;
    private String description;

    public ProductDto() {
    }

    public ProductDto setLowestPrice(Integer lowestPrice) {
        this.lowestPrice = lowestPrice;
        return this;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public ProductDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public Integer getLowestPrice() {
        return lowestPrice;
    }

    public String getDescription() {
        return description;
    }

    public static Integer getHighestPrice(List<ProductDto> productList) {
        return productList.stream()
                .reduce((a, b) -> a.getLowestPrice() > b.getLowestPrice() ? a : b)
                .get()
                .getLowestPrice();

    }

    public static Integer getLowestPrice(List<ProductDto> productList) {
        return productList.stream()
                .reduce((a, b) -> a.getLowestPrice() < b.getLowestPrice() ? a : b)
                .get()
                .getLowestPrice();
    }
}
