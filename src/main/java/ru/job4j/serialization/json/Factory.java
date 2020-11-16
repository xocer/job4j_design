package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.util.Arrays;

public class Factory {
    private String name;
    private Address address;
    private int amountOfWorkers;
    private boolean isArmFactory;
    private String[] products;

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public int getAmountOfWorkers() {
        return amountOfWorkers;
    }

    public boolean isArmFactory() {
        return isArmFactory;
    }

    public String[] getProducts() {
        return products;
    }

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


        JSONObject jsonObject = new JSONObject(factoryJson);
        System.out.println(jsonObject);
        System.out.println(new JSONObject(factory).toString());
    }
}
