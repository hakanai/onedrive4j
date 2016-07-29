package com.palash.onedrive4j;

import com.nickdsantos.onedrive4j.DriveItem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;

/**
 * Created by palash on 7/29/2016.
 */
public class OneDrivePath implements Path {
    private FileSystem fs;

    public DriveItem getDriveItem() {
        return driveItem;
    }

    private DriveItem driveItem;

    public OneDrivePath(FileSystem fs, DriveItem driveItem) {
        this.fs = fs;
        this.driveItem = driveItem;
    }

    @Override
    public FileSystem getFileSystem() {
        return fs;
    }

    @Override
    public boolean isAbsolute() {
        throw new NotImplementedException();
    }

    @Override
    public Path getRoot() {
        throw new NotImplementedException();
    }

    @Override
    public Path getFileName() {
        return this;
    }

    @Override
    public Path getParent() {
        throw new NotImplementedException();
    }

    @Override
    public int getNameCount() {
        throw new NotImplementedException();
    }

    @Override
    public Path getName(int index) {
        throw new NotImplementedException();
    }

    @Override
    public Path subpath(int beginIndex, int endIndex) {
        throw new NotImplementedException();
    }

    @Override
    public boolean startsWith(Path other) {
        throw new NotImplementedException();
    }

    @Override
    public boolean startsWith(String other) {
        throw new NotImplementedException();
    }

    @Override
    public boolean endsWith(Path other) {
        throw new NotImplementedException();
    }

    @Override
    public boolean endsWith(String other) {
        throw new NotImplementedException();
    }

    @Override
    public Path normalize() {
        throw new NotImplementedException();
    }

    @Override
    public Path resolve(Path other) {
        throw new NotImplementedException();
    }

    @Override
    public Path resolve(String other) {
        throw new NotImplementedException();
    }

    @Override
    public Path resolveSibling(Path other) {
        throw new NotImplementedException();
    }

    @Override
    public Path resolveSibling(String other) {
        throw new NotImplementedException();
    }

    @Override
    public Path relativize(Path other) {
        throw new NotImplementedException();
    }

    @Override
    public URI toUri() {
        throw new NotImplementedException();
    }

    @Override
    public Path toAbsolutePath() {
        throw new NotImplementedException();
    }

    @Override
    public Path toRealPath(LinkOption... options) throws IOException {

        throw new NotImplementedException();
    }

    @Override
    public File toFile() {
        throw new NotImplementedException();
    }

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>... events) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public Iterator<Path> iterator() {
        throw new NotImplementedException();
    }

    @Override
    public int compareTo(Path other) {
        throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object other) {
        throw new NotImplementedException();
    }

    @Override
    public int hashCode() {
        return (this.driveItem.name + this.driveItem.file.hashes.sha1Hash).hashCode();
    }

    @Override
    public String toString() {
        return this.driveItem.name;
    }
}
