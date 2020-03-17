package Fruits;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteFile {
    private File fruitFile = new File("Fruits.txt");
    private ArrayList<Fruit> fruitList;
    public WriteFile(ArrayList<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public void addToFile(){
        try {
            if (!fruitFile.exists()) {
                fruitFile.createNewFile();
            }
            FileWriter createFile = new FileWriter(fruitFile);
            for(Fruit f : fruitList){
                createFile.write(f.output()+"\n");
            }
            createFile.close();
            System.out.println("All fruits were added to the file");
         } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
