package com.agung.parking_lot;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileHelper {

    public Path getFileAsPath(String location) {
        return FileSystems.getDefault().getPath(location);
    }

}
