package service;

import java.nio.file.Path;
import java.util.Scanner;

public class CLI {
    public void workWithCli() {
        File file = new File();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Make a choice\n" + "[e]ncrypt | [d]ecrypt | [b]rute force :");
        String command = scanner.nextLine();
        System.out.println("Write filepath");
        Path filePath = Path.of(scanner.nextLine());
        int key = 0;

        if (file.isFileExist(filePath)) {
            if (command.equals("b") || command.equals("BRUTE_FORCE")) {
                new Logic(filePath).readFileEncryptDecrypt(command, key);
            } else {
                System.out.println("Enter key: ");
                key = scanner.nextInt();
                new Logic(filePath).readFileEncryptDecrypt(command, key);
            }
        }
    }
}
