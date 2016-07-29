package com.palash.onedrive4j;

import com.nickdsantos.onedrive4j.Drive;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by palash on 7/29/2016.
 */
public class OneDriveFileSystem extends FileSystem {
    private OneDriveFileSystemProvider _provider;

    public OneDriveFileSystem(OneDriveFileSystemProvider provider) {
        this._provider = provider;
    }

    @Override
    public FileSystemProvider provider() {
        return _provider;
    }

    @Override
    public void close() throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isOpen() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isReadOnly() {
        throw new NotImplementedException();
    }

    @Override
    public String getSeparator() {
        throw new NotImplementedException();
    }

    @Override
    public Iterable<Path> getRootDirectories() {
        try {
            List<Drive> drives = _provider.getDriveService().getDrives(_provider.getOneDrive().getAccessToken());
            List<Path> paths = new ArrayList<>();
            for (Drive drive : drives) {
                paths.add(getPath(drive.id));
            }
            return paths;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Iterable<FileStore> getFileStores() {
        throw new NotImplementedException();
    }

    @Override
    public Set<String> supportedFileAttributeViews() {
        throw new NotImplementedException();
    }

    @Override
    public Path getPath(String first, String... more) {

        throw new NotImplementedException();
    }

    @Override
    public PathMatcher getPathMatcher(String syntaxAndPattern) {
        throw new NotImplementedException();
    }

    @Override
    public UserPrincipalLookupService getUserPrincipalLookupService() {
        throw new NotImplementedException();
    }

    @Override
    public WatchService newWatchService() throws IOException {
        throw new NotImplementedException();
    }
}
