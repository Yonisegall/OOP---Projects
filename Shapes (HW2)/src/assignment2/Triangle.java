package assignment2;
public class Triangle extends Polygon {

    public Triangle(Point[] points, String name) {
        super(points, name);
    }

    @Override
    public double calcArea() { // According to the formula for calculating the area of a triangle
        Point a = this.getPointAt(0);
        Point b = this.getPointAt(1);
        Point c = this.getPointAt(2);
        double result =  0.5 * ((a.getX() * (b.getY() - c.getY())) +
                (b.getX() * (c.getY() - a.getY())) +
                (c.getX() * (a.getY() - b.getY())));
        if (result < 0)
            return result * (-1);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) // if other is null
            return false;
        if (other instanceof Triangle) { // if other is Triangle
            Triangle T = (Triangle) other; // Creating an object of type Triangle
            if (T.getName() == this.getName() &&
                    T.getLeftMostX() == this.getLeftMostX() &&
                    T.getUpperMostY() == this.getUpperMostY() &&
                    T.calcArea() == this.calcArea() &&
                    T.calcCircumference() == this.calcCircumference())
                return true; // if all conditions are true
        }
        return false;
    }
}