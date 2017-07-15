package com.nickdsantos.onedrive4j.examples;

import com.nickdsantos.onedrive4j.OneDrive;
import com.nickdsantos.onedrive4j.Scope;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Created by palash on 7/29/2016.
 */
public class OneDriveNIOExample {

    public static void main(String[] args) throws IOException {
        OneDrive oneDrive = new OneDrive("your access token here");

        List<Path> rootPath = oneDrive.getRootPath();
        Path path = rootPath.get(0);
        System.out.println("path = " + path);

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("dir = " + dir);
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                BasicFileAttributes attributes = Files.readAttributes(file, BasicFileAttributes.class);
                System.out.println("  " + file + ", mt:" + attributes.lastModifiedTime() + ", ct:" + attributes.creationTime());
                return super.visitFile(file, attrs);
            }
        });

    }
}
