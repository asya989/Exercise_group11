
/**
 * Write a description of class Rectangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
/**
 * EXERCISE 5: Rectangle Class (Geometry)
 * PT821: Object-Oriented Programming - Classes and Objects
 */

public class Rectangle {
    private double length;
    private double width;
    private String color;
    private boolean isFilled;

    public Rectangle() {
        this.length = 1;
        this.width = 1;
        this.color = "white";
        this.isFilled = false;
    }

   
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        this.color = "white";
        this.isFilled = false;
    }

   
    public Rectangle(double length, double width, String color, boolean isFilled) {
        this.length = length;
        this.width = width;
        this.color = color;
        this.isFilled = isFilled;
    }

    
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setLength(double length) {
        if (length > 0)
            this.length = length;
    }

    public void setWidth(double width) {
        if (width > 0)
            this.width = width;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    public double calculateDiagonal() {
        return Math.sqrt((length * length) + (width * width));
    }

    public boolean isSquare() {
        return length == width;
    }

    public void resize(double factor) {
        if (factor > 0) {
            length *= factor;
            width *= factor;
        }
    }

    public void displayInfo() {
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Color: " + color);
        System.out.println("Filled: " + isFilled);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Diagonal: " + calculateDiagonal());
        System.out.println("Is Square: " + isSquare());
    }

    
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle(4, 6);
        Rectangle rect3 = new Rectangle(5, 5, "blue", true);

        System.out.println("Rectangle 1:");
        rect1.displayInfo();

        System.out.println("Rectangle 2:");
        rect2.displayInfo();

        System.out.println("Rectangle 3:");
        rect3.displayInfo();

        rect1.resize(3);

        System.out.println("Rectangle 1 after resize:");
        rect1.displayInfo();

        double totalArea = rect1.calculateArea() +
                           rect2.calculateArea() +
                           rect3.calculateArea();

        System.out.println("Total Area of all rectangles: " + totalArea);

        System.out.println("Exercise Complete ===");
    }
}

    


