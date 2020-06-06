package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File folder = new File(args[0]);
        File source = new File(args[1]);
        File destination = new File(source.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(source, destination);
        FileInputStream inputStream;
        Map<String, String> map = new TreeMap<>();
        Queue<File> queue = new PriorityQueue<>();
        Collections.addAll(queue, folder.listFiles());

        while (!queue.isEmpty()){
            File currentFile = queue.remove();
            if (currentFile.isDirectory()){
                Collections.addAll(queue, currentFile.listFiles());
            }else if(currentFile.length()<=50) {
                map.put(currentFile.getName(), currentFile.getAbsolutePath());
            }
        }


        FileOutputStream fileOutputStream = new FileOutputStream(destination, true);
        for (Map.Entry<String, String> value : map.entrySet()){
            inputStream = new FileInputStream(value.getValue());
            byte[] buff = new byte[inputStream.available()];
            int count = inputStream.read(buff);
            fileOutputStream.write(buff);
            fileOutputStream.write("\n".getBytes());
            inputStream.close();
        }
        fileOutputStream.close();
    }
}