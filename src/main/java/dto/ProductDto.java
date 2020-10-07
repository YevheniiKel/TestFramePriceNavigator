package dto;

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
}
