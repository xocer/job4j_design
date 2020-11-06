package ru.job4j.io;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private Path rootPath;

    public void packFiles(List<Path> sources, File target) throws IOException {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(rootPath + "\\" + target)))) {
            for (Path tmp : sources) {
                Path currentPath = rootPath.relativize(tmp);
                zip.putNextEntry(new ZipEntry(currentPath.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(tmp.toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        Zip zip = new Zip();
        zip.rootPath = Paths.get(argZip.directory());
        List<Path> list = Search.search(Paths.get(argZip.directory()), argZip.exclude());
        zip.packFiles(list, new File(argZip.output()));
    }
}
