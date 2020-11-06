package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
                BufferedWriter writer = new BufferedWriter(new FileWriter(path, Charset.forName("UTF-8")))) {
            String userMessage = reader.readLine();
            String answerToUser;
            String separ = System.lineSeparator();
            while (!userMessage.equals(OUT)) {
                if (userMessage.equals(STOP)) {
                    writer.write(userMessage + separ);
                    while (!userMessage.equals(CONTINUE)) {
                        userMessage = reader.readLine();
//                        writer.write(userMessage + separ);
                    }
                    writer.write(userMessage + separ);
                    userMessage = reader.readLine();
                    continue;
                }

                answerToUser = getBotAnswer();
                System.out.println(answerToUser);
                writer.write(userMessage + " " + answerToUser + separ);
                userMessage = reader.readLine();
            }
            writer.write(userMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getBotAnswer() {
        String answer = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers, Charset.forName("UTF-8")))) {
            List<String> arrayAnswers = reader.lines().collect(Collectors.toList());
            Random random = new Random();
            int resultRandom = random.nextInt(arrayAnswers.size() - 1);
            answer = arrayAnswers.get(resultRandom);
        } catch (IOException e) {
            e.getStackTrace();
        }
        return answer;
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("log.txt", "even.txt");
        cc.run();
    }
}
