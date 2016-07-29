package com.nickdsantos.onedrive4j.examples;

import com.nickdsantos.onedrive4j.Drive;
import com.nickdsantos.onedrive4j.OneDrive;

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
        OneDrive oneDrive = new OneDrive("EwAQA61DBAAUGCCXc8wU/zFu9QnLdZXy+YnElFkAAbp58HHgNFEEVCoCYYllrTnYKfLPGfCvGjnRhAsYE0Tgnocz2vfpqI77+UVPVCLVt88eMDjLKsPjCDSqPDztWkeDwHxDFmwg6Qp4Wj80WOSMR63NMOYFMjGrt+fLnaOCcvDepU4wsMBJMOHmngtHMK49QqlKy+XWVwVV88hY2paa2zhroodsvtUYtrWPzwa+Vl18By46pzwTD8xJoC1deEdArwMC6kHWtD6NiyUlE8TK6CBAT5RTEngCGLMt3EzEfUeatonV7BiZqFuRFkFffZ31K9lZpQ1iq7hclzS0pf0EQNjRn3bwMZrrj9N2cmMqimLyApKWjiqx/XeydWEc8ZwDZgAACJAbb7n/Ok5W4AEEb62EyvBw4fHiat/k35MBW5GHkRnMZ2RU77g/yo8oODT2A37Uhtx8rt4ctbLWub44/bGXbeD5JGQdAW+0bymJZiEwDPn7arAIin392LRxVmGUL+sgsZSkIi4AcTW6L3WTFLoQy53U/+znBdDghkzTcOFDnNhk7J7N/eV1KITi1pnbQHa7GoNZtz+4+fHHonBskHZ19tCtIbNaqZh/S7mhnLspLHULw7XJKSwmMoy7sJdW6FYolmgjXaKCbw9YTSpWB+Y3zLrZ0mDV/N1JtdGFKQ/sjDgvai0YvL2oSaMh8YvcH7CDyF1kGeWlml9dPu0e7DYnYhA/M6rVVC6RirzoODieoK/2vozjGxAmeUNwB8VkbBmaTBl2NssclboOOyHj6YMDwv+oGMIL77IEDI3fGEFIoGq+lP7pUP5W7adPa/17HkD9GWEEBbrDVarYoFVFYp9PDUrKGIwtSATUqVLzejeNDGh6YsXVV5zT0UJLoea2uz9R6U19uWL2whj9A3KhyXJNeHGx+ACuhEPn7xw80ZArfH2liKQmIqYokDT0jVUcu0m9lq/HXTe+0k3HS+8qhDOlA5hlnbC4iOwCsPSLm09f5qQooX88Mlq8zvUCh95AktKPYnoVDrXipOt4+ZYRAg==");
        List<Path> rootPath = oneDrive.getRootPath();
        Path path = rootPath.get(0);

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("file = " + file);
                return super.visitFile(file, attrs);
            }
        });

    }
}
