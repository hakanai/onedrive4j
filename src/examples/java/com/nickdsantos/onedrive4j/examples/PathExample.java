package com.nickdsantos.onedrive4j.examples;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by palash on 7/29/2016.
 */
public class PathExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\research-work\\onedrive4j");

        Files.walkFileTree(path,new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("file = " + file);
                return super.visitFile(file,attrs);
            }
        });


    }
}
