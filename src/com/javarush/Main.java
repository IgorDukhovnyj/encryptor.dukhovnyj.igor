package com.javarush;

import com.javarush.service.CLI;
import com.javarush.service.File;
import com.javarush.service.Logic;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        if (args.length == 2 || args.length == 3) {
            String command = args[0];
            Path filePath = Path.of(args[1]);
            int key = Integer.parseInt(args[2]);
            new Logic(filePath).readFileEncryptDecrypt(command, key);
        } else {
            new CLI().workWithCli();
        }
    }
}
