package ra.project.entity;

public class CountProductByCategory {
    private String categoryName;
    private int countProduct;

    @Override
    public String toString() {
        return "CountProductByCategory{" +
                "categoryName='" + categoryName + '\'' +
                ", countProduct=" + countProduct +
                '}';
    }

    public String getCategoryName() {

        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public CountProductByCategory(String categoryName, int countProduct) {
        this.categoryName = categoryName;
        this.countProduct = countProduct;
    }

    public CountProductByCategory() {
    }
}
