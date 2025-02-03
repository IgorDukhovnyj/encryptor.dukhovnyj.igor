package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class File {
    public boolean isFileExist(Path path) {
        try {
            if (!Files.exists(path)) {
                System.out.println("File not found");
                return false;
            }
            if (!Files.isRegularFile(path)) {
                System.out.println("Object is not a file");
                return false;
            }
            if (!path.toString().endsWith(".txt")) {
                System.out.println("Use .txt file");
                return false;
            }
            if (!Files.isReadable(path)) {
                System.out.println("File is no read");
                return false;
            }
            if (Files.size(path) == 0) {
                System.out.println("File is no have text");
                return false;
            }
            return true;
        } catch (IOException e) {
            System.out.println("Validation failed: " + e.getMessage());
            return false;
        }
    }
}