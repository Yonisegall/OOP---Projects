package assignment2;
public class Circle extends Shape implements Comparable<Circle> {

    private double radius;
    private Point center;

    public static final double PI = 3.14;

    public Circle() {
        this.radius = 0;
        this.center = new Point();
    }

    public Circle(double radius, Point center, String name) {
        super(name);
        this.radius = radius;
        this.center = new Point(center);
    }

    public Circle(Circle other) {
        if (other != null){
            super.setName(other.getName());
            radius = other.radius;
            center = new Point(other.center);
        }
    }

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public double calcCircumference() {
        return PI * 2 * (this.radius); // Circle perimeter formula
    }

    @Override
    public double calcArea() {
        return PI * (this.radius) * (this.radius); // Circle area formula
    }

    @Override
    public void shift(double xShift, double yShift) {
        this.center.setX(this.center.getX() + xShift);
        this.center.setY(this.center.getY() + yShift);
    }
    @Override
    public int compareTo(Circle other) {
        if (other == null)
            return 1;
        if(this.equals(other)) // equal
            return 0;
        if (this.radius < other.radius) // other is bigger
            return -1;
        return 1;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) // if other is null
            return false;
        if (other instanceof Circle){ // if other is Circle
            Circle C = (Circle) other; // Creating an object of type Circle
            if (C.getName() == this.getName() &&
                    C.calcCircumference() == this.calcCircumference() &&
                    C.calcArea() == this.calcArea() &&
                    C.getLeftMostX() == this.getLeftMostX() &&
                    C.getUpperMostY() == this.getUpperMostY())
                return true; // if all conditions are true
        }
        return false;
    }
    @Override
    public double getLeftMostX(){
        return this.center.getX() - this.radius; // The center point minus the radius
    }

    @Override
    public double getUpperMostY(){
        return this.center.getY() + this.radius; // The central point plus the radius
    }
}