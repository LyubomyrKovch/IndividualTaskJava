package Fruits;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public class Citrus extends Fruit implements Serializable {
    private double vitaminC;

    public Citrus() {
        super();
    }

    public Citrus(String name, String color, double vitaminC) {
        super(name, color);
        this.vitaminC = vitaminC;
    }

    public double getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(double vitaminC) {
        this.vitaminC = vitaminC;
    }

    @Override
    public void input() throws IOException {
        System.out.println("Enter citrus");
        super.input();
        System.out.println("Please enter how many vitamin c this citrus contains");
        this.vitaminC = Double.parseDouble(br.readLine());
    }

    @Override
    public String output() {
        return "Fruit " + getName() + ", color " + getColor() + ", has " + getVitaminC() + " vitamin C";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Citrus)) return false;
        if (!super.equals(o)) return false;
        Citrus citrus = (Citrus) o;
        return Double.compare(citrus.vitaminC, vitaminC) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vitaminC);
    }
}