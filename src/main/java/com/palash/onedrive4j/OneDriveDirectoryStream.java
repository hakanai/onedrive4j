package com.palash.onedrive4j;

import com.nickdsantos.onedrive4j.DriveItem;
import com.nickdsantos.onedrive4j.DriveService;
import com.nickdsantos.onedrive4j.OneDrive;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by palash on 8/1/2016.
 */
public class OneDriveDirectoryStream implements DirectoryStream<Path> {

    private OneDrivePath _path;
    private Filter<? super Path> _filter;

    public OneDriveDirectoryStream(OneDrivePath dir, Filter<? super Path> _filter) {
        this._path = dir;
        this._filter = _filter;
    }

    @Override
    public Iterator<Path> iterator() {
        return new OneDriveDirectoryStreamIterator();
    }

    @Override
    public void close() throws IOException {

    }

    private class OneDriveDirectoryStreamIterator implements Iterator<Path> {
        private Iterator<OneDrivePath> oneDrivePathIterator;

        public OneDriveDirectoryStreamIterator() {
            DriveItem driveItem = _path.getDriveItem();
            OneDrive oneDrive = _path.getOneDrive();
            DriveService driveService = oneDrive.getDriveService();
            try {
                List<DriveItem> childItems = driveService.getChildItems(oneDrive.getAccessToken(), driveItem.id);
                ArrayList<OneDrivePath> oneDrivePaths = new ArrayList<>();
                for (DriveItem childItem : childItems) {
                    oneDrivePaths.add(new OneDrivePath(oneDrive.getFileSystem(), childItem));
                }
                oneDrivePathIterator = oneDrivePaths.iterator();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean hasNext() {
            return oneDrivePathIterator.hasNext();
        }

        @Override
        public OneDrivePath next() {
            return oneDrivePathIterator.next();
        }

        @Override
        public void remove() {
            throw new NotImplementedException();
        }
    }
}
