package assignment3;

import java.io.*;
import java.io.ObjectInputStream;
import java.util.Iterator;

public class PersonRegistry {
    private boolean corrupted;
    private MyArrayList<Person> my_people;

    public PersonRegistry(String filePath){
        this();
        //my_people = new MyArrayList<>();
        corrupted = false;

        if (filePath.endsWith(".bin"))
            try {
                FileInputStream file_Input = new FileInputStream(filePath);
                ObjectInputStream object_input = new ObjectInputStream(file_Input);
                this.my_people = (MyArrayList<Person>) object_input.readObject();
                object_input.close();
            }
            catch (IOException | ClassNotFoundException e) {
                this.corrupted = true;
            }
        else {
            File my_file = new File(filePath);
            readCsvFile(my_file);
        }
    }

    private void readCsvFile(File myFile){
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(myFile));
            while ((line = br.readLine()) != null){
                String[] person = line.split(",");
                if (person.length == 3) {
                    //corrupted = true;
                    String name = person[0].trim();
                    int age = Integer.parseInt(person[1].trim());
                    double lucky_number = Double.parseDouble(person[2].trim());

                    Person my_person = new Person(name, age, lucky_number);
                    this.my_people.add(my_person);
                }
               else{
                   corrupted = true;
                }
            }
            br.close();
        }
        catch (IOException e) {
            corrupted = true;
        }
    }

    public PersonRegistry(){
        my_people = new MyArrayList<>();
    }
    public PersonRegistry(Iterable<? extends Person> persons){
        this();

        //my_people = new MyArrayList<>();

        for (Person person : persons) {
            this.my_people.add(person);
        }
    }

    public PersonRegistry(Person[] persons){
        my_people = new MyArrayList<>();

        for (Person person : persons) {
            my_people.add(person);
        }
    }

    public void add(Person p){
        my_people.add(p);
    }

    public Person get (int index){
        return my_people.get(index);
    }

    public int maxAge() {
        int maxAge = 0;
        for (int i = 0; i < my_people.size(); i++) {
            if (my_people.get(i).getAge() > maxAge)
                maxAge = my_people.get(i).getAge();
        }
        return maxAge;
    }

    public boolean writeCSV(String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (int i = 0; i < my_people.size(); i++) {
                writer.println(my_people.get(i).getName() + "," + my_people.get(i).getAge()
                       + "," + my_people.get(i).getLuckyNumber());
            }
            writer.close();
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }

    public Iterator<Person> iterator(){
        return my_people.iterator();
    }

    public boolean isCorrupted() {
        return this.corrupted;
    }

    public double meanLuckyNumber() {
        int Size = my_people.size();
        double count = 0;
        for (int i = 0; i < Size; i++){
            count +=  my_people.get(i).getLuckyNumber();
        }
        return count/Size;
    }

    public MyArrayList<String> uniqueNames() {
        MyArrayList<String> my_array = new MyArrayList<>();
        for (int i = 0; i < my_people.size(); i++){
            my_array.add(my_people.get(i).getName());
        }
        return my_array;
    }

    public int count(Person person) {
        int count = 0;
        for (int i = 0; i < my_people.size(); i++){
            if (my_people.get(i).equals(person))
                count++;
        }
        return count;
    }
}
