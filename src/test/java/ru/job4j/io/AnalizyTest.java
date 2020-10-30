package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenAllGood() throws IOException {
        File source = folder.newFile("test");
        File target = folder.newFile("resultTest");

        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01\n" +
                    "\n" +
                    "200 10:57:01\n" +
                    "\n" +
                    "400 10:58:01\n" +
                    "\n" +
                    "200 10:59:01\n" +
                    "\n" +
                    "500 11:01:02\n" +
                    "\n" +
                    "200 11:02:02 ");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:58:01;10:59:0111:01:02;11:02:02"));
    }
}
