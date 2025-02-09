package com.javarush.service;

import com.javarush.files.LangSize;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Logic extends LangSize {
    public List<String> text;
    private Path path;
    public Logic(Path path) {
        this.path = path;
    }
    public void readFileEncryptDecrypt(String textCiperMenu, int key) {
        String s = "";
        try {
            text = Files.readAllLines(path);
            for (String line : text) {
                s = recognizesWhitchLangEncryptDecrypt(line, textCiperMenu, key);
                saveTextToFile(path.getFileName().toString(), s);
            }
        } catch (IOException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
    protected String getEncryptedFileName(String originalFileName) {
        int dotIndex = originalFileName.lastIndexOf(".");
        boolean endsWithEncrypt = originalFileName.endsWith("[ENCRYPT].txt");

        if (endsWithEncrypt) {
            if (dotIndex != -1) {
                String namePart = originalFileName.substring(0, dotIndex);
                String extensionPart = originalFileName.substring(dotIndex);
                return namePart + "[DECRYPT]" + extensionPart;
            } else {
                return originalFileName + "[DECRYPT]";
            }
        } else {
            if (dotIndex != -1) {
                String namePart = originalFileName.substring(0, dotIndex);
                String extensionPart = originalFileName.substring(dotIndex);
                return namePart + "[ENCRYPT]" + extensionPart;
            } else {
                return originalFileName + "[ENCRYPT]";
            }
        }
    }
    void saveTextToFile(String fileName, String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(text);
        }
    }
}
