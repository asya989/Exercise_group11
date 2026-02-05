
/**
 * Write a description of class Exercise3_Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product {

    // Private attributes
    private String productCode;
    private String productName;
    private String category;
    private double unitPrice;
    private int quantityInStock;
    private int reorderLevel;

    // 2. Default constructor
    public Product() {
        this.productCode = "UNKNOWN";
        this.productName = "UNKNOWN";
        this.category = "UNKNOWN";
        this.unitPrice = 0;
        this.quantityInStock = 0;
        this.reorderLevel = 10;
    }

    // 2. Parameterized constructor
    public Product(String productCode, String productName,
                             String category, double unitPrice, int quantityInStock) {
        this.productCode = productCode;
        this.productName = productName;
        this.category = category;
        setUnitPrice(unitPrice);
        setQuantityInStock(quantityInStock);
        this.reorderLevel = 10;
    }

    // 3. Getters
    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    // 4. Setters with validation
    public void setUnitPrice(double unitPrice) {
        if (unitPrice > 0) {
            this.unitPrice = unitPrice;
        } else {
            System.out.println("Unit price must be greater than 0.");
        }
    }

    public void setQuantityInStock(int quantityInStock) {
        if (quantityInStock >= 0) {
            this.quantityInStock = quantityInStock;
        } else {
            System.out.println("Quantity cannot be negative.");
        }
    }

    public void setReorderLevel(int reorderLevel) {
        if (reorderLevel > 0) {
            this.reorderLevel = reorderLevel;
        } else {
            System.out.println("Reorder level must be greater than 0.");
        }
    }

    // 5. addStock()
    public void addStock(int quantity) {
        if (quantity > 0) {
            quantityInStock += quantity;
            System.out.println(quantity + " units added to stock.");
        }
    }

    // 5. sellProduct()
    public boolean sellProduct(int quantity) {
        if (quantity > 0 && quantity <= quantityInStock) {
            quantityInStock -= quantity;
            System.out.println(quantity + " units sold.");
            return true;
        } else {
            System.out.println("Insufficient stock to sell.");
            return false;
        }
    }

    // 5. calculateStockValue()
    public double calculateStockValue() {
        return unitPrice * quantityInStock;
    }

    // 5. needsReorder()
    public boolean needsReorder() {
        return quantityInStock <= reorderLevel;
    }

    // 5. applyDiscount()
    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            unitPrice -= unitPrice * (percentage / 100);
            System.out.println("Discount of " + percentage + "% applied.");
        }
    }

    // 5. displayProductInfo()
    public void displayProductInfo() {
        System.out.println("----- PRODUCT INFO -----");
        System.out.println("Code: " + productCode);
        System.out.println("Name: " + productName);
        System.out.println("Category: " + category);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Stock Quantity: " + quantityInStock);
        System.out.println("Reorder Level: " + reorderLevel);
        System.out.println("Stock Value: " + calculateStockValue());
        System.out.println("Needs Reorder: " + (needsReorder() ? "YES" : "NO"));
        System.out.println("------------------------\n");
    }

    // 6. Main method (testing)
    public static void main(String[] args) {
        System.out.println("=== Product Inventory Exercise ===\n");

        // Create products
        Product product1 =
                new Product("PRD001", "Laptop", "Electronics", 1500000, 25);

        Product product2 =
                new Product("PRD002", "Office Chair", "Furniture", 350000, 8);

        Product product3 =
                new Product("PRD003", "Notebook", "Stationery", 5000, 100);

        // Display all products
        product1.displayProductInfo();
        product2.displayProductInfo();
        product3.displayProductInfo();

        // Sell 20 laptops
        product1.sellProduct(20);

        // Check reorder for product2
        System.out.println("Product2 needs reorder? " + product2.needsReorder());

        // Add stock to product2
        product2.addStock(50);

        // Apply discount to product3
        product3.applyDiscount(15);

        // Display final stock values
        product1.displayProductInfo();
        product2.displayProductInfo();
        product3.displayProductInfo();

        System.out.println("=== Exercise Complete ===");
    }
}
