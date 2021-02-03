package ru.job4j.io.xml;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "car")
public class Number {
    @XmlAttribute
    private String id;

    public Number() {

    }

    public Number(String number) {
        this.id = number;
    }

    @Override
    public String toString() {
        return "Number{"
                + "id='" + id + '\''
                + '}';
    }
}
