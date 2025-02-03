package com.javarush.files;

import service.Alphabet;

import java.util.ArrayList;

public class LangSize {
    ArrayList<Character> transformedText = new ArrayList<>();

    public String recognizesWhitchLangEncryptDecrypt(String text, String textCiperMenu, int key) {
        CaesarCipher caesarCipher = new CaesarCipher();
        BruteForce bruteForce = new BruteForce();
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (Alphabet.TEST_DICTIONARY.contains(currentChar)) {
                transformedText.add(currentChar);
            } else if (Alphabet.EN_BIG.contains(currentChar) || Alphabet.EN_SMALL.contains(currentChar)) {
                count++;
            }
        }
        if ("e".equals(textCiperMenu) || "ENCRYPT".equals(textCiperMenu)) {
            if (count > 0) {
                CaesarCipher.caesarCipher(text, key);
            }
            return CaesarCipher.getTransformedText();
        }
        if ("d".equals(textCiperMenu) || "DECRYPT".equals(textCiperMenu)) {
            CaesarCoder caesarCoder = new CaesarCoder();
            if (count > 0) {
                caesarCoder.caesarCoder(text, key);
            }
            return caesarCoder.getTransformedText();
        }
        if ("b".equals(textCiperMenu) || "BRUTE_FORCE".equals(textCiperMenu)) {
            if (count > 0) {
                bruteForce.bruteForceDecrypt(text);
            }
            return bruteForce.getText();
        }
        return null;
    }
}