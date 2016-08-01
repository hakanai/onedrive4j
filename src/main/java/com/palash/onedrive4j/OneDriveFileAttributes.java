package com.palash.onedrive4j;

import com.nickdsantos.onedrive4j.DriveItem;

import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.ParseException;

/**
 * Created by palash on 7/29/2016.
 */
public class OneDriveFileAttributes implements BasicFileAttributes {
    private DriveItem driveItem;

    public OneDriveFileAttributes(DriveItem driveItem) {
        this.driveItem = driveItem;
    }

    @Override
    public FileTime lastModifiedTime() {
        try {
            return FileTime.fromMillis(OneDriveUtil.parseDate(driveItem.fileSystemInfo.lastModifiedDateTime));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FileTime lastAccessTime() {
        try {
            return FileTime.fromMillis(OneDriveUtil.parseDate(driveItem.fileSystemInfo.lastModifiedDateTime));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FileTime creationTime() {
        try {
            return FileTime.fromMillis(OneDriveUtil.parseDate(driveItem.fileSystemInfo.createdDateTime));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isRegularFile() {
        return driveItem.file != null;
    }

    @Override
    public boolean isDirectory() {
        return driveItem.folder != null;
    }

    @Override
    public boolean isSymbolicLink() {
        return false;
    }

    @Override
    public boolean isOther() {
        return false;
    }

    @Override
    public long size() {
        return driveItem.size;
    }

    @Override
    public Object fileKey() {
        return null;
    }
}
