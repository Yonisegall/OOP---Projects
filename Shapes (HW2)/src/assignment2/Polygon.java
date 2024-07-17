package assignment2;
public abstract class Polygon extends Shape {

    private Point[] points;
    private int accessCounter;

    public Polygon(Point[] points, String name) {
        this.points = points;
        this.setName(name);
    }

    public Point getPointAt(int index) {
        accessCounter++;
        return new Point(points[index]);
    }

    public int getAccessCounter() { return accessCounter; }
    public int getNumOfPoints() { return points.length; }

    @Override
    public double calcCircumference() {
        double result = 0;
        int a = 0;
        int b = 1;
        while (b < points.length){
            result += (points[b].distance(points[a])); // the distance between the points
            a ++;
            b ++;
        }
        return result + points[0].distance(points[points.length - 1]); // the distance between the last first point
    }

    @Override
    public double getLeftMostX() {
        double most_left = points[0].getX();
        int count = 0;
        while (count < points.length){
            if (points[count].getX() < most_left) // Checks what the smallest x is
                most_left = points[count].getX();
            count ++;
        }
        return most_left;
    }

    @Override
    public double getUpperMostY() {
        double most_up = points[0].getY();
        int count = 0;
        while (count < points.length){
            if (points[count].getY() > most_up) // Checks what the largest y is
                most_up = points[count].getY();
            count ++;
        }
        return most_up;
    }

    @Override
    public void shift(double xShift, double yShift) {
        int count = 0;
        while (count < points.length) { // Goes through all the points
            this.points[count].setX(points[count].getX() + xShift);
            this.points[count].setY(points[count].getY() + yShift);
            count ++;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) // if other is null
            return false;
        if (other instanceof Polygon) { // if other is Polygon
            Polygon P = (Polygon) other; // Creating an object of type Polygon
            if (P.getName() == this.getName() &&
                    P.getLeftMostX() == this.getLeftMostX() &&
                    P.getUpperMostY() == this.getUpperMostY() &&
                    P.calcArea() == this.calcArea() &&
                    P.calcCircumference() == this.calcCircumference())
                return true; // if all conditions are true
        }
        return false;
    }
}