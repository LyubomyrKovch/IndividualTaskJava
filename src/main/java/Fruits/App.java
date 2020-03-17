package Fruits;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static List<Fruit> fruitList = new ArrayList<Fruit>();
    private static List<Fruit> collorList = new ArrayList<Fruit>();
    private static Sorter sort = new Sorter((ArrayList<Fruit>) fruitList, (ArrayList<Fruit>) collorList);
    private static WriteFile writeFile = new WriteFile((ArrayList<Fruit>) fruitList);
    private static SerializationCollection fruitCollection = new SerializationCollection((ArrayList<Fruit>) fruitList);

    public static void main(String[] args) throws IOException {

        fruitList.add(new Fruit());
        fruitList.add(new Fruit());
        fruitList.add(new Citrus());
        fruitList.add(new Citrus());

        //Input the data about fruits frome the console
        for (Fruit fruits : fruitList) {
            try {
                fruits.input();
            } catch (NumberFormatException e) {
                System.out.println("Wrong format of entered numbers");
            } catch (IOException e) {
                System.out.println("Try later");
            }
        }
        //Output the data about yellow fruits
        String yellow = "yellow";
        sort.colorSort(yellow);
        System.out.println("Yellow fruits:");
        for (Fruit f : collorList) {
            System.out.println(f.output());
        }
        //Sort the collection by name
        sort.byName();
        System.out.println("Sort the collection by name");
        for (Fruit fruits : fruitList) {
            System.out.println(fruits.output());
        }
        //Add fruit list to the file
        writeFile.addToFile();
        //Serialize and deserialize the collection to XML file
        fruitCollection.serializeFruit();
        fruitCollection.deserializeFruit();
    }
}

