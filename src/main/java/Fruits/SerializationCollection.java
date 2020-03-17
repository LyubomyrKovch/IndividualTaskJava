package Fruits;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class SerializationCollection {
    private File file = new File("Fruits.xml");
    private ArrayList<Fruit> fruit;
    public SerializationCollection(ArrayList<Fruit> fruit) {
        this.fruit = fruit;
    }

    public void serializeFruit() throws IOException {
        if (!file.exists()) file.createNewFile();
        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(file));
        encoder.writeObject(this.fruit);
        encoder.close();
    }

    public void deserializeFruit() throws FileNotFoundException {
        XMLDecoder decoder = new XMLDecoder(new FileInputStream(file));
        this.fruit = (ArrayList<Fruit>) decoder.readObject();
        decoder.close();
    }

}