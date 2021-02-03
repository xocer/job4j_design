package ru.job4j.io.xml;

public class Car {
    private final boolean isTruck;
    private final int yearOfManufacture;
    private final String modelName;
    private final Number number;
    private final String[] functions;

    public Car(boolean isTruck, int yearOfManufacture,
               String modelName, Number number, String[] functions) {
        this.isTruck = isTruck;
        this.yearOfManufacture = yearOfManufacture;
        this.modelName = modelName;
        this.number = number;
        this.functions = functions;
    }

    public static void main(String[] args) {
        new Car(false, 2020, "BMW",
                new Number("C507AM"), new String[] {"подогрев руля", "стеклоподъемники"});
    }
}
