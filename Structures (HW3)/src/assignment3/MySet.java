package assignment3;

import java.io.Serializable;
import java.util.Iterator;

public class MySet <T extends Serializable> implements Iterable<T>,Serializable{
    private MyArrayList<T> my_set; // Creating a private variable of a MyArrayList type

    /**
     * A constructor that creates a new MyArrayList
     */
    public MySet() {
        this.my_set = new MyArrayList<>();
    }

    /**
     * A constructor that accepts an iterable and adds all its members to the set
     * @param collection iterable
     */
    public MySet(Iterable<? extends T> collection) {
        my_set = new MyArrayList<>();
        for (T i: collection)
            add(i);
    }

    /**
     * A constructor that get an array and copies it
     * @param arr An array with values of type T
     */
    public MySet(T[] arr) {
        my_set = new MyArrayList<T>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null)
                break;
            else
                add(arr[i]);
        }
    }

    /**
     * The method adds a given value to the set
     * @param element A value of type T
     */
    public void add(T element) {
        if (!contains(element))
            my_set.add(element);
    }

    /**
     * The method receives a value and checks if it is in the set
     * @param element A value of type T
     * @return
     */

    public boolean contains(T element) {
        for (int i = 0; i < my_set.size(); i++){
            if (my_set.get(i).equals(element))
                return true;
        }
        return false;
    }

    /**
     * The method returns the size of the set
     * @return size of the array
     */
    public int size(){
        return my_set.size();
    }
    /**
     * The method deletes a given element from the set
     * @param element A value of type T
     */

    public void remove (T element){
        if (my_set.index(element) == -1)
            return;
        my_set.remove(element);
    }

    /**
     * The method gets MySet and produces a new set which
       is the union of the current set with the other set
     * @param other MySet type
     * @return New MySet is the union of the current set with the other set
     */
    public MySet<T> union(MySet<T> other) {
        MySet<T> new_set = new MySet<T>();
        for (int i = 0; i < my_set.size(); i++) {
            new_set.add(my_set.get(i));
        }
        for (int j = 0; j < other.size();j++){
            if (!new_set.contains(other.my_set.get(j)))
                new_set.add(other.my_set.get(j));
        }
        return new_set;
    }

    /**
     * The method produces a new set which is the cut of
       the set the current one with an extra set
     * @param other MySet type
     * @return New MySet is the cut of the current set and the other set
     */

    public MySet<T> intersection (MySet<T> other){
        MySet<T> new_set = new MySet<T>();
        for (int i = 0; i < my_set.size(); i++){
            if (other.contains(my_set.get(i)))
                new_set.add(my_set.get(i));
        }
        return new_set;
    }

    /**
     * The method produces a new set which is the subtraction of the set
     * the current one in the extra set.

     * @param other  A variable of MySet type
     * @return A new set which is the subtraction of the two sets
     */
    
    public MySet<T> difference (MySet<T> other){
        MySet<T> new_set = new MySet<T>();
        for (int i = 0; i < my_set.size(); i++){
            if (!other.contains(my_set.get(i))) {
                new_set.add(my_set.get(i));
            }
        }
        return new_set;
    }

    /**
     *
     * 
     * @param other
     * @return
     */
    public boolean equals (MySet<T> other){
        for (int i = 0; i < my_set.size(); i++){
            if (!other.contains(my_set.get(i)))
                return false;
        }
        for (int j = 0; j < other.size(); j++){
            if (!contains(other.my_set.get(j)))
                return false;
        }
        return true;
    }

    public Iterator<T> iterator(){
        return my_set.iterator();
    }
}



