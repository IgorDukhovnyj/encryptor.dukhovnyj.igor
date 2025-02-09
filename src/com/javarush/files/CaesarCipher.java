package com.javarush.files;

import com.javarush.service.Alphabet;

import java.util.ArrayList;

public class CaesarCipher {
    static ArrayList<Character> transformedText = new ArrayList<>();

    static void caesarCipher(String text, int key) {
        try {
            for (int i = 0; i < text.length(); i++) {
                char currentChar = text.charAt(i);
                if (Alphabet.EN_BIG.contains(currentChar)) {
                    int index = Alphabet.EN_BIG.indexOf(currentChar);
                    int newIndex = (index + key) % Alphabet.EN_BIG.size();
                    transformedText.add(Alphabet.EN_BIG.get(newIndex));
                } else if (Alphabet.EN_SMALL.contains(currentChar)) {
                    int index = Alphabet.EN_SMALL.indexOf(currentChar);
                    int newIndex = (index + key) % Alphabet.EN_SMALL.size();
                    transformedText.add(Alphabet.EN_SMALL.get(newIndex));
                } else {
                    transformedText.add(currentChar);
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getTransformedText() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : transformedText) {
            stringBuilder.append(c);
        }
        String result = stringBuilder.toString();
        return result;
    }
}
