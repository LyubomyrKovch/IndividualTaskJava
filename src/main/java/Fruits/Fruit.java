package Fruits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Objects;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

public class Fruit implements Serializable {

    public Fruit() {
    }


    public Fruit(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void input() throws IOException {
        System.out.println("Please enter fruit name");
        this.name = toLowerCase(br.readLine());

        System.out.println("Please enter fruit color");
        this.color = toLowerCase(br.readLine());
    }

    public String output() {
        return "Fruit " + getName() + ", color " + getColor();
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruit)) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(br, fruit.br) &&
                Objects.equals(name, fruit.name) &&
                Objects.equals(color, fruit.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(br, name, color);
    }

    protected transient BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String name;
    private String color;
}
