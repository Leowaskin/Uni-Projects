import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products;
    //Constuctor
    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product newProduct) {
        products.add(newProduct);
    }

    public void removeProduct(String newProductID) {
        products.removeIf(product -> product.getProductId().equals(newProductID));//-> is a lambda expression, that he 
    }

    public Product findProduct(String newProductID) {
        for (Product product : products) {
            if (product.getProductId().equals(newProductID)) {
                return product;
            }
        }
        return null;
    }

    public void displayAllProducts() {
        for (Product product : products) {
            product.displayDetails();
            System.out.println("-------------------");
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}


