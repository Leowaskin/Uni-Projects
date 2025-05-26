import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Inventory inventory = new Inventory(); // Create an inventory instance
        inventory.getProducts().addAll(Data.loadData()); // Loading the products from file
        Transaction transaction = new Transaction(inventory); // Create a transaction instance
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        boolean running = true; // Control Flag for the while loop

        while (running) { // The Main program's dislpay
            System.out.println("\nWelcome To The Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Sell Product");
            System.out.println("4. Report Low Stock");
            System.out.println("5. Change Product Details");
            System.out.println("6. Add Stock");
            System.out.println("7. View Total Revenue");
            System.out.println("8. Save Data");
            System.out.println("9. Save transaction History");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt(); // Checks for the user's input
            scanner.nextLine(); // Consume newline left-over

            switch (choice) { // used for calling differnt functions, as asked by the user
                case 1: // allows the user to add a new product
                    System.out.print("\nEnter Product ID: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Stock Quantity: ");
                    int stock = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline left-over
                    
                    Product product = new TV(productId, name, stock, price);
                    inventory.addProduct(product);
                    System.out.println("Product added successfully.");
                    break;

                case 2: // Displays all the products in the inventory
                    System.out.println("Displaying all products:");
                    inventory.displayAllProducts();
                    break;

                case 3: // Allows the user to sell the product
                    System.out.print("\nEnter Product ID to sell: ");
                    String sellProductId = scanner.nextLine();
                    System.out.print("Enter Quantity to sell: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    transaction.sellProduct(sellProductId, quantity);// sells the product, according to the user input
                    break;

                case 4: // allows user to check if there is a product with stock below the the specified
                        // threshold
                    System.out.print("\nEnter low stock threshold: "); // asks the user the specified threshold
                    int threshold = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    Reporter reporter = new Reporter(inventory); // Creates an instance of reporter
                    reporter.reportLowStock(threshold);
                    break;

                case 5: // Allows the user to chnge the details of the product
                    System.out.print("\nEnter Product ID to change: ");
                    String changeProductId = scanner.nextLine();
                    Product productToChange = inventory.findProduct(changeProductId);
                    if (productToChange != null) {
                        System.out.print("Enter new Product Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new Stock Quantity: ");
                        int newStock = scanner.nextInt();
                        System.out.print("Enter new Price: ");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline left-over

                        productToChange.setStock(newStock); // changes the stock quantity to the the one specified by
                                                            // the user
                        productToChange.setName(newName); // changes the name to the the one specified by the user
                        productToChange.setPrice(newPrice); // changes the price to the the one specified by the user
                        System.out.println("\n***********Product details updated successfully.***********");
                    } else {
                        System.out.println("xxxxxxProduct not found.xxxxxx");
                    }
                    break;

                case 6: // Allows user to add stock to existing products
                    System.out.print("\nEnter Product ID to add stock: ");
                    String addStockProductId = scanner.nextLine();
                    Product productToAddStock = inventory.findProduct(addStockProductId);
                    if (productToAddStock != null) {
                        System.out.print("Enter quantity to add to stock: "); // asks the user quantity of stock to be
                                                                              // added
                        int additionalStock = scanner.nextInt();
                        scanner.nextLine(); // Consume newline left-over
                        productToAddStock.setStock(productToAddStock.getStock() + additionalStock);
                        System.out.println("\n**********Stock updated successfully.**********");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 7: // Displays the total revenue
                    transaction.displayRevenue();
                    break;

                case 8: // saves the data in the file
                    Data.saveData(inventory.getProducts());
                    System.out.println("*******Data saved successfully.*******");
                    break;
                case 9:
                    System.out.print("Enter file name to save transaction history (e.g., history.txt): ");
                    String fileName = scanner.nextLine();
                    transaction.saveTransactionHistory(fileName);
                    break;
                case 10: // Exits the main program
                    System.out.println("\n------------Exiting the system. Goodbye!-------------");
                    running = false;
                    break;

                default: // if a value other than 1-9 is given displays this message
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }

        scanner.close();
    }
}
