package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String amigo) {
    }

    public void setPartOfContent(String programmer) {
    }

    public void setMinSize(int i) {
    }

    public void setMaxSize(int i) {
    }

    public List<Path> getFoundFiles() {
        return new LinkedList<>();
    }
}
