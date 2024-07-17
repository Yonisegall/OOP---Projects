package assignment2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class ShapeContainer implements Iterable<Shape> {

    public class ShapeContainerIterator implements Iterator<Shape> {

        private int index = 0; // represent the index in array

        @Override
        public boolean hasNext() {
            return (shapes[index] != null);
        }

        @Override
        public Shape next() {
            if (!hasNext())
                throw new RuntimeException("No more elements"); // if there is no more elements
            Shape next = shapes[index];
            index ++;
            return next;
        }
    }

    public static class NameComparator implements Comparator<Shape> {

        @Override
        public int compare(Shape o1, Shape o2) {
            if (o1 == null){
                if (o2 == null)
                    return 0;
                return 1;
            }
            if (o1.getName() == null){
                if (o2.getName() == null){
                    return 0;
                }
                return 1;
            }
            int l_o1 = o1.getName().length();
            int l_o2 = o2.getName().length();
            int min = 0;
            if (l_o1 > l_o2)
                min = l_o2;
            else
                min = l_o1;

            for (int i = 0; i < min; i++){
                if (o1.getName().charAt(i) > o2.getName().charAt(i))
                    return 1;
                if (o1.getName().charAt(i) < o2.getName().charAt(i))
                    return -1;
            }
            if (l_o1 > l_o2)
                return 1;
            if (l_o1 == l_o2)
                return 0;
            return -1;
        }
    }

    public static class CircumferenceComparator implements Comparator<Shape> {

        @Override
        public int compare(Shape o1, Shape o2) {
            if (o1 == null){
                if (o2 == null)
                    return 0;
                return 1;
            }
            if (o2.calcCircumference() == o1.calcCircumference())
                return 0;
            if (o1.calcCircumference() > o2.calcCircumference())
                return 1;
            return -1;
        }
    }

    public static class EdgeComparator implements Comparator<Shape> {

        @Override
        public int compare(Shape o1, Shape o2){
            if (o1 == null){
                if (o2 == null)
                    return 0;
                return 1;
            }
            if (o1.getLeftMostX() > o2.getLeftMostX())
                return 1;
            if (o1.getLeftMostX() == o2.getLeftMostX()){
                if (o1.getUpperMostY() > o2.getUpperMostY())
                    return 1;
                if (o1.getUpperMostY() == o2.getUpperMostY())
                    return 0;
                return -1;
            }
            return -1;
        }
    }

    private Shape[] shapes;

    public ShapeContainer() {
        this.shapes = new Shape[1];
    }

    public ShapeContainer(Shape[] shapes) {
        this.shapes = shapes;
    }

    public Shape[] getShapes(){
        return shapes;
    }

    public void addShape(Shape newShape) {
        boolean full_array = true; // boolean
        for(int count = 0; count < this.shapes.length; count++){
            if(shapes[count] == null){
                full_array = false;
                shapes[count] = newShape;
                break;
            }
        }
        if(full_array){
            Shape[] new_array = new Shape[shapes.length * 2];
            int i = 0;
            while (i < shapes.length) {
                new_array[i] = shapes[i];
                i++;
            }
            new_array[i] = newShape;
            this.shapes = new_array;
        }
    }

    public int contains(Shape shape) {
        int count = 0;
        while (count < shapes.length){
            if (shapes[count] == null)
                break;
            if (shapes[count].getClass() == shape.getClass()){
                if (shapes[count].equals(shape))
                    return count;
            }
            count ++;
        }
        return -1;
    }

    public double calcAllCircumference() {
        double result = 0;
        int count = 0;
        while (count < shapes.length){
            if (shapes[count] == null)
                break;
            result += shapes[count].calcCircumference();
            count ++;
        }
        return result;
    }

    public double calcCircleArea() {
        double result = 0;
        int count = 0;
        while (count < shapes.length) {
            if (shapes[count] == null)
                break;
            if (shapes[count] instanceof Circle) {
                result += shapes[count].calcArea();
            }
            count++;
        }
        return result;
    }

    public double calcPolygonArea() {
        double result = 0;
        int count = 0;
        while (count < shapes.length) {
            if (shapes[count] instanceof Polygon) {
                result += shapes[count].calcArea();
            }
            count++;
        }
        return result;
    }

    public void sort(Comparator<Shape> comparator) {
        Arrays.sort(this.shapes, comparator);
    }

    @Override
    public Iterator<Shape> iterator() {
        return new ShapeContainerIterator();
    }
}