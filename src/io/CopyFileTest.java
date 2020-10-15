package io;

import java.io.*;

public class CopyFileTest {
    public static void main(String[] args) throws IOException {
//        writeTextFile(new File("origin.txt"));
//        readTestFile(new File("origin.txt"));
        copyTextFile(new File("origin.txt"),new File("target.txt"));
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
