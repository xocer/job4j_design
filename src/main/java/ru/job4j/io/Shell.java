package ru.job4j.io;

public class Shell {
    private String root = "";

    public void cd(String path) {

        if (path.contains("/")) {
            root += path;
        } else {
            root += "/" + path;
        }

        if (path.endsWith("..")) {
            int lastIndexSlash = root.lastIndexOf("/");
            String tmp = root.substring(0, lastIndexSlash);
            lastIndexSlash = tmp.lastIndexOf("/");
            root = tmp.substring(0, lastIndexSlash + 1);
            System.out.println(root);
        }
    }

    public String pwd() {
        return root;
    }

    public static void main(String[] args) {
        Shell shell = new Shell();
        shell.cd("/user/..");
    }
}
