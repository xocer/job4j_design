package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            List<String> list = getList(source);
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                String[] s = list.get(i).split(" ");

                if ((s[0].equals("200") || s[0].equals("300")) && flag) {
                    writer.write(s[1] + System.lineSeparator());
                    flag = false;

                } else if ((s[0].equals("400") || s[0].equals("500")) && !flag) {
                    writer.write(s[1] + ";");
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> getList(String source) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))){
            list = reader.lines().filter(x -> !x.isEmpty()).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {

        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "unavailable.csv");
//        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
//            out.println("15:01:30;15:02:32");
//            out.println("15:10:30;23:12:32");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}