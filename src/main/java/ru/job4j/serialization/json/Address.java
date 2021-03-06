package ru.job4j.serialization.json;

public class Address {
    private final String address;

    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Address{"
                + "address='" + address + '\''
                + '}';
    }
}
