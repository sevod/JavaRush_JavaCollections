package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new LinkedList<>();

        ArrayDeque<File> path = new ArrayDeque<>();

        File folder = new File(root);
        path.add(folder);
        while (path.peek() != null){
            File file = path.poll();
            if (file.isDirectory()){
                for (File file2: file.listFiles()) {
                    if (file2.isDirectory())
                        path.offer(file2);
                    else
                        list.add(file2.getAbsolutePath());
                }
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getFileTree("c:/test"));

    }
}
