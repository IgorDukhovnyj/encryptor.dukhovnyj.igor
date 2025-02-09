package com.javarush.service;

import java.util.ArrayList;

public class BruteForce {
    private String text;

    public void bruteForceDecrypt(String encryptedText) {
        for (int key = 0; key <= 26; key++) {
            String decryptedText = decrypt(Alphabet.EN_BIG, Alphabet.EN_SMALL, encryptedText, key);
            if (isDecryptedTextValid(decryptedText)) {
                System.out.println("Job done, key is " + key);
                text = decryptedText;
                break;
            }
        }
    }

    private String decrypt(ArrayList<Character> EN_BIG, ArrayList<Character> EN_SMALL, String text, int key) {
        StringBuilder decryptedText = new StringBuilder();
        int alphabetSize = EN_BIG.size();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (EN_BIG.contains(ch)) {
                int originalIndex = EN_BIG.indexOf(ch);
                int newIndex = (originalIndex - key + alphabetSize) % alphabetSize;
                decryptedText.append(EN_BIG.get(newIndex));
            } else {
                decryptedText.append(ch);
            }
        }
        return decryptedText.toString();
    }

    private boolean isDecryptedTextValid(String decryptedText) {
        try {
            Alphabet alphabet = new Alphabet();
            boolean isValid = false;
            for (Character word : alphabet.TEST_DICTIONARY) {
                if (containsCharacter(decryptedText, word)) {
                    isValid = true;
                }
            }
            return isValid;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public String getText() {
        return text;
    }

    private boolean containsCharacter(String str, Character ch) {
        if (str == null || str.isEmpty() || ch == null) {
            return false;
        }
        return str.indexOf(ch) != -1;
    }
}
