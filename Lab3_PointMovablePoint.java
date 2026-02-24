
/**
 * Write a description of class point here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

class Point {
    private double x;
    private double y;

    // Constructors
    public Point() {
        this(0.0, 0.0);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters and Setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Set both coordinates
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Get both coordinates as an array
    public double[] getXY() {
        return new double[]{x, y};
    }

    // toString representation
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}


class MovablePoint extends Point {
    private double xSpeed;
    private double ySpeed;

    // Constructors
    public MovablePoint() {
        this(0.0, 0.0, 0.0, 0.0);
    }

    public MovablePoint(double xSpeed, double ySpeed) {
        this(0.0, 0.0, xSpeed, ySpeed);
    }

    public MovablePoint(double x, double y, double xSpeed, double ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    // Getters and Setters for speed
    public double getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    // Set both speeds
    public void setSpeed(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    // Get both speeds as an array
    public double[] getSpeed() {
        return new double[]{xSpeed, ySpeed};
    }

    // Move the point by adding speed to current position
    public MovablePoint move() {
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
        return this; 
    }

    // toString representation
    @Override
    public String toString() {
        return super.toString() + " speed=(" + xSpeed + ", " + ySpeed + ")";
    }
}


public class Lab3_PointMovablePoint {
    public static void main(String[] args) {

        // Point Objects
        System.out.println("--- Section 1: Point Objects ---");

        // Create and test Point objects
        Point p1 = new Point();
        System.out.println("Default point: " + p1);

        Point p2 = new Point(3.0, 4.0);
        System.out.println("Point at (3, 4): " + p2);

        p2.setX(5.0);
        p2.setY(6.0);
        System.out.println("After setX(5), setY(6): " + p2);

        double[] coords = p2.getXY();
        System.out.println("getXY() = [" + coords[0] + ", " + coords[1] + "]");

        // MovablePoint Objects 
        System.out.println("\n--- Section 2: MovablePoint Objects ---");

        // Create a MovablePoint and test basic properties
        MovablePoint mp1 = new MovablePoint(0.0, 0.0, 2.0, 3.0);
        System.out.println("Initial position: " + mp1);

        // Inherited methods from Point
        System.out.println("X coordinate: " + mp1.getX());
        System.out.println("Y coordinate: " + mp1.getY());

        //Movement
        System.out.println("\n--- Section 3: Movement ---");

        //Demonstrate the move() method
        System.out.println("Before move: " + mp1);
        mp1.move();
        System.out.println("After 1st move: " + mp1);
        mp1.move();
        System.out.println("After 2nd move: " + mp1);
        mp1.move();
        System.out.println("After 3rd move: " + mp1);

        // Change speed and continue moving
        mp1.setSpeed(1.0, -1.0);
        System.out.println("\nSpeed changed to (1.0, -1.0)");
        mp1.move();
        System.out.println("After move: " + mp1);
        mp1.move();
        System.out.println("After move: " + mp1);


        Point p3 = new MovablePoint(1.0, 1.0, 0.5, 0.5);
        System.out.println("p3 (Point ref): " + p3);
        System.out.println("p3 class: " + p3.getClass().getSimpleName());


      
        if (p3 instanceof MovablePoint) {
            MovablePoint mp2 = (MovablePoint) p3;
            mp2.move();
            System.out.println("After downcast and move: " + mp2);
            System.out.println("p3 also changed: " + p3);
        }

        

        // ToCreate multiple moving points and simulate movement
        MovablePoint[] points = {
            new MovablePoint(0.0, 0.0, 1.0, 1.0),   
            new MovablePoint(10.0, 0.0, -1.0, 0.5),  
            new MovablePoint(5.0, 5.0, 0.0, -2.0)    
        };

        System.out.println("Starting positions:");
        for (int i = 0; i < points.length; i++) {
            System.out.println("  Point " + (i + 1) + ": " + points[i]);
        }

        // Simulate 5 steps of movement
        for (int step = 1; step <= 5; step++) {
            System.out.println("\nStep " + step + ":");
            for (int i = 0; i < points.length; i++) {
                points[i].move();
                System.out.println("  Point " + (i + 1) + ": " + points[i]);
            }
        }



        
    }
}