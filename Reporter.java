public class Reporter {
    private Inventory inventory;

    public Reporter(Inventory newInventory) {
        this.inventory = newInventory;
    }

    public void reportLowStock(int threshold) {
        System.out.println("\nLow Stock Report:");
        for (Product product : inventory.getProducts()) {
            if (product.getStock() < threshold) {
                System.out.println("Product ID: " + product.getProductId() + ", Name: " + product.getName()
                        + ", Stock: " + product.getStock());
            }
        }
        System.out.println("-------------------\n");
    }

    public void reportAllProducts() {
        System.out.println("Inventory Report:");
        inventory.displayAllProducts();
    }
}
