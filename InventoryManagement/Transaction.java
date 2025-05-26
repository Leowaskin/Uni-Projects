import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private Inventory inventory;
    private double totalRevenue;
    private List<String> transactionHistory;

    public Transaction(Inventory inventory) {
        this.inventory = inventory;
        this.totalRevenue = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void sellProduct(String productId, int quantity) {
        Product product = inventory.findProduct(productId);
        if (product != null && product.getStock() >= quantity) {
            product.setStock(product.getStock() - quantity);
            double saleAmount = quantity * product.getPrice();
            totalRevenue += saleAmount;
            String transaction = "Sold " + quantity + " units of " + product.getName() + 
                                 " (ID: " + productId + ") for $" + saleAmount;
            transactionHistory.add(transaction); // Save transaction details
            System.out.println(transaction);
        } else {
            String error = "Failed to sell " + quantity + " units of Product ID: " + productId + 
                           " - Insufficient stock or product not found.";
            transactionHistory.add(error); // Save failure message
            System.out.println(error);
        }
    }

    public void displayRevenue() {
        System.out.println("Total Revenue: $" + totalRevenue);
    }

    public void saveTransactionHistory(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Transaction History:\n");
            for (String record : transactionHistory) {
                writer.write(record);
                writer.newLine();
            }
            writer.write("\nTotal Revenue: $" + totalRevenue);
            System.out.println("Transaction history saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving transaction history.");
            e.printStackTrace();
        }
    }
}

