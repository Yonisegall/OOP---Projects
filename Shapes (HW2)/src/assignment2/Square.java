package assignment2;
public class Square extends Polygon {
    public Square(Point[] points, String name) {
        super(points, name);
    }

    @Override
    public double calcArea() {
        Point a = getPointAt(0);
        Point b = getPointAt(1);
        return b.distance(a)* b.distance(a); // Square area calculation formula
    }

    @Override
    public double calcCircumference() {
        Point a = getPointAt(0);
        Point b = getPointAt(1);
        return 4 * b.distance(a); // formula for calculating the perimeter of a square
    }

    @Override
    public boolean equals(Object other){
        if (other == null) // if other is null
            return false;
        if (other instanceof Square) { // if other is Square
            Square S = (Square) other; // Creating an object of type Square
            if (S.getName() == this.getName() &&
                    S.getLeftMostX() == this.getLeftMostX() &&
                    S.getUpperMostY() == this.getUpperMostY() &&
                    S.calcArea() == this.calcArea() &&
                    S.calcCircumference() == this.calcCircumference())
                return true; // if all conditions are true
        }
        return false;
    }
}