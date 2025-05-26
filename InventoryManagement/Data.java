import java.io.*; // for file handaling
import java.util.ArrayList; // for arrays

public class Data {
    private static final String FILE_PATH = "inventory_data.txt"; // file name, cannot be modified

    public static void saveData(ArrayList<Product> products) { // this function writes the data in to the file for
                                                               // saving it
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) { // creates writer insatnce for
                                                                                      // file, we used buffer writer due
                                                                                      // to it's efficency
            for (Product product : products) { // loops through the array and adds each item to the file with it'
                                               // detail.
                writer.append(product.getProductId() + "," + product.getName() + "," + product.getStock() + ","
                        + product.getPrice());
                writer.newLine();
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) { // to handle any error while writng to the file
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static ArrayList<Product> loadData() { // this function reads from the file and retrives all the data for the
                                                  // user
        ArrayList<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String productId = data[0];
                    String name = data[1];
                    int stock = Integer.parseInt(data[2]);
                    double price = Double.parseDouble(data[3]);
                    products.add(new TV(productId, name, stock, price));
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return products;
    }
}
