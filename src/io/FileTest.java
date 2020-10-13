package io;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
//        deleteFile();
//        hasJpgFile(new File("file\\text0"));
        iterateDir(new File("file"));
    }

    public static void iterateDir(File file){
        if (file.isDirectory()){
            System.out.println(file.getUsableSpace());
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                iterateDir(files[i]);
            }
            file.delete();
        }else {
            System.out.println(file.getName());
            file.delete();
        }
    }

    public static void hasJpgFile(File file){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().contains(".jpg")){
                    System.out.println(files[i].getName());
                }
            }
        }else {
            System.out.println("该文件不是目录！");
        }
    }

    public static void deleteFile() {
        File file = new File("file");

        for (int i = 0; i < 10; i++) {
            File file1 = new File(file, "text" + i + ".txt");
            boolean newFile = file1.delete();
            System.out.println("删除文件text" + i + ":" + newFile);
        }
    }

    public static void createFile() {
        File file = new File("file");
        boolean mkdir = file.mkdir();
        System.out.println("创建file目录：" + mkdir);

        for (int i = 0; i < 10; i++) {
            File file2 = new File(file, "text" + i);
            boolean mkdir1 = file2.mkdir();
            System.out.println("创建目录text" + i + ":" + mkdir1);
            File file1 = new File(file2, "text" + i + ".txt");
            try {
                boolean newFile = file1.createNewFile();
                System.out.println("创建文件text" + i + ":" + newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
