
/**
 * Write a description of class Exercise1_MobilePhone here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MobilePhone {

    private String brand;
    private String model;
    private double price;
    private int batteryLevel; 
    private boolean isOn;

    //Default constructor
    public MobilePhone() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.price = 0.0;
        this.batteryLevel = 100;
        this.isOn = false;
    }

    //Parameterized constructor
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    //Getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
    
    public boolean isOn() {
        return isOn;
    }

    //Setters with validation
    public void setPrice(double price) {
        this.price = (price >= 0.0)? price : 0.0;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = (batteryLevel >= 0 && batteryLevel<=100)? batteryLevel : 0;
    }

    //Behavior methods
    public void turnOn() {
        if (batteryLevel > 0) {
            isOn = true;
            System.out.println("Phone is now ON.");
        } else {
            System.out.println("Battery empty. Cannot turn on phone.");
        }
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Phone is now OFF.");
    }

    public void makeCall(String contactName) {
        if (!isOn) {
            System.out.println("Phone is OFF. Turn it on first.");
            return;
        }
        batteryLevel -= 5;
        System.out.println("Calling " + contactName + "...");
    }

    public void chargeBattery(int minutes) {
        int addedCharge = minutes * 2;
        batteryLevel += addedCharge;

        if (batteryLevel > 100) {
            batteryLevel = 100;
        }

        System.out.println("Phone charged for " + minutes + " minutes.now it has " + batteryLevel + "%");
    }

    //Display info
    public void displayInfo() {
        System.out.println("----- Phone Information -----");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Power Status: " + (isOn ? "ON" : "OFF"));
        System.out.println("-----------------------------");
    }

    //Main method (testing)
    public static void main(String[] args) {
        System.out.println("=== Mobile Phone Exercise ===\n");

        // Default constructor
        MobilePhone phone1 = new MobilePhone();

        // Parameterized constructor
        MobilePhone phone2 = new MobilePhone("Samsung", "Galaxy S24", 2500000);

        // Turn on phone
        phone2.setBatteryLevel(100);
        phone2.turnOn();

        // Make 3 calls
        phone2.makeCall("abdull");
        phone2.makeCall("maryam");
        phone2.makeCall("rukayya");

        // Display info
        phone2.displayInfo();

        // Charge for 10 minutes
        phone2.chargeBattery(5);

        // Display info again
        phone2.displayInfo();

        System.out.println("\n=== Exercise Complete ===");
    }
}
