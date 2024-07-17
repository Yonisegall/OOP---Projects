package assignment2;
public abstract class Shape implements EdgePointer {

    private String name;

    public Shape() {
        name=null;
    }

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract double calcCircumference();

    public abstract double calcArea();

    public abstract void shift(double xShift, double yShift);

    @Override
    public boolean equals(Object o) {
        return false;
    }
}