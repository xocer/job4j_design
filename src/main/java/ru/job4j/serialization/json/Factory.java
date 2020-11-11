package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Factory {
    private String name;
    private Address address;
    private int amountOfWorkers;
    private boolean isArmFactory;
    private String[] products;

    public Factory(String name, Address address, int amountOfWorkers, boolean isArmFactory, String... products) {
        this.name = name;
        this.address = address;
        this.amountOfWorkers = amountOfWorkers;
        this.isArmFactory = isArmFactory;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", amountOfWorkers=" + amountOfWorkers +
                ", isArmFactory=" + isArmFactory +
                ", products=" + Arrays.toString(products) +
                '}';
    }

    public static void main(String[] args) {
        Factory factory = new Factory("Силовые машины", new Address("Свердловская набережная 5"), 700, true, "turbines");
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(factory));

        final String factoryJson =
                "{"
                        + "\"name\":\"Силовые машины\","
                        + "\"address\":"
                        + "{"
                        + "\"address\":\"Свердловская набережная 5\""
                        + "},"
                        + "\"amountOfWorkers\":700,"
                        + "\"isArmFactory\":true,"
                        + "\"products\":[\"turbines\"]"
                        + "}";
        final Factory factoryMod = gson.fromJson(factoryJson, Factory.class);
        System.out.println(factoryMod);
    }
}
