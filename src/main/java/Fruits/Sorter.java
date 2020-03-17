package Fruits;

import java.util.ArrayList;
import java.util.Comparator;

public class Sorter {
    private ArrayList<Fruit> fruitList;
    private ArrayList<Fruit> colorList;

    public Sorter(ArrayList<Fruit> fruitList, ArrayList<Fruit> collorList) {
        this.fruitList = fruitList;
        this.colorList = collorList;
    }

    public ArrayList<Fruit> getfruitList() {
        return fruitList;
    }

    public void setfruitList(ArrayList<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public ArrayList<Fruit> getColorList() {
        return colorList;
    }

    public void setColorList(ArrayList<Fruit> colorList) {
        this.colorList = colorList;
    }

    public void byName() {
        fruitList.sort(new Comparator<Fruit>() {
            public int compare(Fruit o1, Fruit o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }


    public void colorSort(String color) {
        for (Fruit f : fruitList)
            if (f.getColor().equals(color)) {
                colorList.add(f);
            }
    }
}
