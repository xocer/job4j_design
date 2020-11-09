package ru.job4j.io;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        BasicConfigurator.configure();

        long one = 1L;
        double two = 2;
        float three = 3F;
        byte four = 4;
        char five = '5';
        short six = 6;
        int seven = 7;
        boolean eight = true;

        LOG.debug("{}, {}, {}, {}, {}, {}, {}, {}", one, two, three, four, five, six, seven, eight);
    }
}