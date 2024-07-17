import assignment2.*;

public class MainRunShapes {
    public static boolean fequal(double v1, double v2) {
        return Math.abs(v1 - v2) <= 1e-5;
    }

    public static void CircleTest() {
        Circle c1 = new Circle(1, new Point(1, 1), "C1");
        Circle c2 = new Circle();
        Circle c3 = new Circle(1, new Point(1, 1), "C1");
        Circle c4 = new Circle(0.5, new Point(1, 1), "C2");
        Circle c5 = new Circle(c1);
        Circle c6 = new Circle(2, new Point(1, 1), "C6");
        if (!c1.equals(c3))
            System.out.println("Problem with assigmant2.Circle equals");

        if (!(c2.getRadius() == 0 && c2.getCenter().getX() == 0 && c2.getCenter().getY() == 0))
            System.out.println("Problem with assigmant2.Circle default constructor");

        if (c1.compareTo(c4) < 1)
            System.out.println("Problem with assigmant2.Circle compare method");

        if (!(c5.getCenter().getX() == c1.getCenter().getX() && c5.getCenter().getY() == c1.getCenter().getY() &&
                c5.getRadius() == c1.getRadius() && c5.getName().equals(c1.getName())))
            System.out.println("Problem with assigmant2.Circle copy constructor");

        if (!fequal(c6.calcCircumference(), 12.56)) {
            System.out.println("Problem with assigmant2.Circle circumference calculation");
        }

        if (!fequal(c6.calcCircumference(), 12.56)) {
            System.out.println("Problem with assigmant2.Circle area calculation");
        }

        c6.shift(1,-1);
        if(!c6.getCenter().equals(new Point(2,0)))
            System.out.println("Problem with assigmant2.Circle shifting");
    }

    public static void SquareTest() {
        Square s1 = new Square(new Point[]{new Point(0, 0), new Point(0, 3), new Point(3, 3), new Point(3, 0)}, "S1");
        Square s2 = new Square(new Point[]{new Point(0, 0), new Point(0, 3), new Point(3, 3), new Point(3, 0)}, "S1");
        if (!s1.equals(s2)) {
            System.out.println("Problem with assigmant2.Square equals");
        }

        if (!fequal(s1.calcCircumference(), 12)) {
            System.out.println("Problem with assigmant2.Square circumference");
        }

        if (!fequal(s1.calcArea(), 9)) {
            System.out.println("Problem with assigmant2.Square area");
        }

        s1.shift(10,10);
        if(!s1.getPointAt(2).equals(new Point(13,13)))
            System.out.println("Problem with assigmant2.Square shifting");
    }

    public static void TriangleTest() {
        Triangle t1 = new Triangle(new Point[]{new Point(0, 0), new Point(6, 6), new Point(6, 0)}, "T1");
        Triangle t2 = new Triangle(new Point[]{new Point(0, 0), new Point(6, 6), new Point(6, 0)}, "T1");
        if (!t1.equals(t2)) {
            System.out.println("Problem with assigmant2.Triangle equals");
        }

        if (!fequal(t1.calcCircumference(), 20.485281374238568)) {
            System.out.println("Problem with assigmant2.Square circumference");
        }

        if (!fequal(t1.calcArea(), 18)) {
            System.out.println("Problem with assigmant2.Square area");
        }

        t1.shift(1,-1);
        if(!t1.getPointAt(2).equals(new Point(7,-1)))
            System.out.println("Problem with assigmant2.Triangle shifting");
    }

    public static void EdgePointerTest() {
        EdgePointer ep1 = new Square(new Point[]{new Point(0, 0), new Point(0, 3), new Point(3, 3), new Point(3, 0)}, "S1");

        if(ep1.getUpperMostY()!=3)
            System.out.println("Problem with assigmant2.EdgePointer getUpperMostY");

        if(ep1.getLeftMostX()!=0)
            System.out.println("Problem with assigmant2.EdgePointer getLeftMostX");
    }

    public static void ShapeContainerTest() {
        Shape s1 = new Triangle(new Point[]{new Point(0, 0), new Point(6, 6), new Point(6, 0)}, "T1");
        Shape s2 = new Square(new Point[]{new Point(0, 0), new Point(0, 3), new Point(3, 3), new Point(3, 0)}, "S1");
        Shape s3 = new Circle(1, new Point(1, 1), "C1");
        Shape s4 = new Circle(2, new Point(0, 0), "C1");
        Shape s5 = new Square(new Point[]{new Point(0, 0), new Point(0, 3), new Point(3, 3), new Point(3, 0)}, "S1");
        Shape s6 = new Circle(1, new Point(1, 1), "C22");
        Shape[] shapes = {s1,s2,s3,null};
        ShapeContainer sc = new ShapeContainer(shapes);
        sc.addShape(s4);
        Shape[] scShapes = sc.getShapes();
        if(!(scShapes[0].equals(s1) && scShapes[1].equals(s2) && scShapes[2].equals(s3) && scShapes[3].equals(s4)))
            System.out.println("Problem with assigmant2.ShapeContainer addShape");
        if(sc.contains(s5)!=1)
            System.out.println("Problem with assigmant2.ShapeContainer contains when shape exists");
        if(sc.contains(s6)!=-1)
            System.out.println("Problem with assigmant2.ShapeContainer contains when shape does not exist");

        if(!fequal(sc.calcAllCircumference(),51.32528137423857)){
            System.out.println("Problem with assigmant2.ShapeContainer calcAllCircumference");
        }

        if(!fequal(sc.calcCircleArea(),15.7)){
            System.out.println("Problem with assigmant2.ShapeContainer calcCircleArea");
        }

        if(!fequal(sc.calcPolygonArea(),27)){
            System.out.println("Problem with assigmant2.ShapeContainer calcPolygonArea");
        }
    }

    public static void main(String[] args) {
        CircleTest();
        SquareTest();
        TriangleTest();
        EdgePointerTest();
        ShapeContainerTest();
        System.out.println("Done");
    }
}