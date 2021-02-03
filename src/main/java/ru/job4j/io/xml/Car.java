package ru.job4j.io.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private boolean isTruck;

    @XmlAttribute
    private int yearOfManufacture;

    @XmlAttribute
    private String modelName;

    private Number number;

    @XmlElementWrapper(name = "functions")
    @XmlElement(name = "function")
    private String[] functions;

    public Car() {

    }

    public Car(boolean isTruck, int yearOfManufacture,
               String modelName, Number number, String[] functions) {
        this.isTruck = isTruck;
        this.yearOfManufacture = yearOfManufacture;
        this.modelName = modelName;
        this.number = number;
        this.functions = functions;
    }

    @Override
    public String toString() {
        return "Car{"
                + "isTruck=" + isTruck
                + ", yearOfManufacture=" + yearOfManufacture
                + ", modelName='" + modelName + '\''
                + ", number=" + number
                + ", functions=" + Arrays.toString(functions)
                + '}';
    }

    public static void main(String[] args) throws JAXBException, IOException {
        Car car = new Car(false, 2020, "BMW",
                new Number("C507AM"), new String[]{"подогрев руля", "стеклоподъемники"});

        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter writer = new StringWriter();
        marshaller.marshal(car, writer);
        String xml = writer.getBuffer().toString();
        System.out.println(xml);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        Car result = (Car) unmarshaller.unmarshal(reader);
        System.out.println(result);
    }
}
