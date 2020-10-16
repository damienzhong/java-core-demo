package io;

import java.io.*;

public class CopyFileTest {
    public static void main(String[] args) throws IOException {
//        writeTextFile(new File("origin.txt"));
//        readTestFile(new File("origin.txt"));
//        copyTextFile(new File("origin.txt"),new File("target.txt"));

        copyImgFile(new File("origin.jpg"),new File("target.jpg"));
    }

    /**
     * 复制图片
     * @param origin
     * @param target
     * @throws IOException
     */
    public static void copyImgFile(File origin, File target) throws IOException {
        if (!origin.exists()) {
            origin.createNewFile();
        }

        FileInputStream fileInputStream = new FileInputStream(origin);
        BufferedInputStream bis = new BufferedInputStream(fileInputStream);

        if (!target.exists()) {
            target.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(target);
        BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);


        byte[] bytes = new byte[fileInputStream.available()];
        while (bis.read(bytes)!=-1){
            bos.write(bytes);
        }

        bos.close();
        bis.close();
    }

    /**
     * 复制文本
     * @param origin
     * @param target
     * @throws IOException
     */
    public static void copyTextFile(File origin, File target) throws IOException {
        if (!origin.exists()) {
            origin.createNewFile();
        }

        String originContent = readTestFile(origin);
        System.out.println(originContent);
        System.out.println(originContent.length());
        writeTextFile(target,originContent);
    }

    /**
     * 读取文本内容
     * @param file
     * @return
     * @throws IOException
     */
    public static String readTestFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while (bufferedInputStream.read(bytes) != -1) {
            sb.append(new String(bytes));
        }

        bufferedInputStream.close();

        return sb.toString();
    }

    /**
     * 往文本文件写入内容
     *
     * @param file
     * @throws IOException
     */
    public static void writeTextFile(File file, String content) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(content.getBytes());
        bufferedOutputStream.close();
    }

}
