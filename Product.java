public abstract class Product implements Item {
    // Attributes
    private String productId;
    private String name;
    private int stock;
    private double price;

    // Constructors
    public Product(String newProductID, String newName, int newStock, double newPrice) {
        this.productId = newProductID;
        this.name = newName;
        this.stock = newStock;
        this.price = newPrice;
    }

    // Methods
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setStock(int newStock) {
        this.stock = newStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public abstract void displayDetails();
}
