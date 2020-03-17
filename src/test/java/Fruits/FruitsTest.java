package Fruits;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class FruitsTest {
    List<Fruit> fruitList = new ArrayList();
    List<Fruit> colorList = new ArrayList();
    Sorter sorter = new Sorter((ArrayList<Fruit>) fruitList, (ArrayList<Fruit>) colorList);

    @BeforeTest
    void setUp() {
        fruitList.add(new Fruit("banana", "yellow"));
        fruitList.add(new Fruit("apple", "red"));
        fruitList.add(new Citrus("lemone", "yellow",0.53));
    }


    @Test
    void output() {
        for (Fruit f : fruitList) {
            String expected;
            if(f.getClass() == Citrus.class){
                expected = String.format("Fruit %s, color %s, has %s vitamin C", f.getName(), f.getColor(), ((Citrus) f).getVitaminC());
            }else{
                expected = String.format("Fruit %s, color %s", f.getName(), f.getColor());
            }
            String actual = f.output();
            assertEquals(expected, actual);
        }
    }
    @Test
    void byName() {
        List<Fruit> expected = new ArrayList<Fruit>();
        expected.add(new Fruit("apple", "red"));
        expected.add(new Fruit("banana", "yellow"));
        expected.add(new Citrus("lemone", "yellow",0.53));
        sorter.byName();
        ReflectionAssert.assertReflectionEquals(expected, fruitList);
    }


    @Test
    void colorSort(){

        List<Fruit> expected = new ArrayList<Fruit>();
        expected.add(new Fruit("banana", "yellow"));
        expected.add(new Citrus("lemone", "yellow",0.53));
        sorter.colorSort("yellow");
        ReflectionAssert.assertReflectionEquals(expected, colorList);

    }
}