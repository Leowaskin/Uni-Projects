public class TV extends Product{
    public TV(String newProductID, String newName, int newStock, double newPrice) {
        super(newProductID, newName, newStock, newPrice);
    }

    @Override
    public void displayDetails() {
        System.out.println('\n');
        System.out.println("Product ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Stock: " + getStock());
        System.out.println("Price: $" + getPrice());
    }
}
