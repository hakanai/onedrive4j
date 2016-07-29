package com.palash.onedrive4j;

import com.nickdsantos.onedrive4j.DriveService;
import com.nickdsantos.onedrive4j.OneDrive;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.net.URI;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;

/**
 * Created by palash on 7/29/2016.
 */
public class OneDriveFileSystemProvider extends FileSystemProvider {
    OneDrive _oneDrive;
    FileSystem _theFileSystem;

    public OneDriveFileSystemProvider(OneDrive oneDrive) {
        this._oneDrive = oneDrive;
        this._theFileSystem = new OneDriveFileSystem(this);
    }

    public DriveService getDriveService() {
        return _oneDrive.getDriveService();
    }

    public OneDrive getOneDrive() {
        return _oneDrive;
    }

    @Override
    public String getScheme() {
        return OneDrive.DEFAULT_SCHEME;
    }

    @Override
    public FileSystem newFileSystem(URI uri, Map<String, ?> env) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public FileSystem getFileSystem(URI uri) {
        return _theFileSystem;
    }

    @Override
    public Path getPath(URI uri) {
        return this._theFileSystem.getPath(uri.getPath());
    }

    @Override
    public SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public DirectoryStream<Path> newDirectoryStream(Path dir, DirectoryStream.Filter<? super Path> filter) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public void createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public void delete(Path path) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public void copy(Path source, Path target, CopyOption... options) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public void move(Path source, Path target, CopyOption... options) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSameFile(Path path, Path path2) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isHidden(Path path) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public FileStore getFileStore(Path path) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public void checkAccess(Path path, AccessMode... modes) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public <V extends FileAttributeView> V getFileAttributeView(Path path, Class<V> type, LinkOption... options) {
        throw new NotImplementedException();
    }

    @Override
    public <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> type, LinkOption... options) throws IOException {
        return (A) new OneDriveFileAttributes(((OneDrivePath)path).getDriveItem());
    }

    @Override
    public Map<String, Object> readAttributes(Path path, String attributes, LinkOption... options) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public void setAttribute(Path path, String attribute, Object value, LinkOption... options) throws IOException {
        throw new NotImplementedException();
    }
}
