package assignment3;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList <T extends Serializable> implements Iterable<T>,Serializable{
    private SimpleArray<T> arr; // Creating a private variable of a SimpleArray type

    /**
     * A constructor that creates a MyArrayList of size 1
     */
    public MyArrayList() {
        arr = new SimpleArray<>(1);
    }

    /**
     * A constructor that get an array and copies it
     *
     * @param arr An array with values of type T
     */
    public MyArrayList(T[] arr) {
        this.arr = new SimpleArray<T>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            this.arr.set(i, arr[i]);
        }
    }


    /**
     * The function returns the value at a given index
     *
     * @param index The index whose value you want to get in the array
     * @return the value at the given index
     */
    public T get(int index) {
        if (index > size() - 1 || index < -1)
            throw new IndexOutOfBoundsException("The index" + index + "doesn't found");
        else
            return arr.get(index);
    }

    /**
     * The method returns the size of the array
     *
     * @return size of the array
     */
    public int size() {
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != null)
                count++;
        }
        return count;
    }

    /**
     * The method adds a given value to the array
     *
     * @param element A value of type T
     */

    public void add(T element) {
        if (arr.get(arr.size() - 1) != null) {
            SimpleArray<T> new_arr = new SimpleArray<T>(arr.size() * 2);
            for (int i = 0; i < arr.size(); i++)
                new_arr.set(i, arr.get(i));
            new_arr.set(arr.size(), element);
            arr = new_arr;
        } else {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) == null) {
                    arr.set(i, element);
                    break;
                }
            }
        }
    }

    /**
     * The method deletes a given element from the array
     *
     * @param element A value of type T
     */
    public void remove(T element) {
        boolean in_array = false;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == element) {
                in_array = true;
                int j = 1;
                T current = arr.get(0);
                while (i< arr.length()) {
                    if (i + j >= arr.length())
                        current = null;
                    else
                        current = arr.get(i+j);
                    if (current == element){
                        j++;
                        continue;
                    }
                    arr.set(i, current);
                    i++;
                }
            }
        }
        if (!in_array)
            throw new NoSuchElementException("The element " + element + " doesn't found");
    }

    /**
     * The method receives a certain value and returns the index that is located in the array
     *
     * @param element A value of type T
     * @return The index of the desired value
     */
    public int index(T element) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == element)
                return i;
        }
        return -1;
    }

    /**
     * The method receives a certain value and counts how many times it is in the array
     *
     * @param element A value of type T
     * @return The number of times a value appears in the array
     */
    public int count(T element) {
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == element)
                count++;
        }
        return count;
    }

    public SimpleArray<T> getUnderlyingSimpleArray() {
        return this.arr;
    }

    public int capacity() {
        return this.arr.length();
    }

    public class MyArrayListIterator implements Iterator<T> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < arr.size() && arr.get(index) != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            else {
                index++;
                return arr.get(index - 1);
            }
        }
    }

    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }
}
