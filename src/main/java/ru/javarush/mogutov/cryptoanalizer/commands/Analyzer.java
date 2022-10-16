package ru.javarush.mogutov.cryptoanalizer.commands;

import java.util.*;

import static ru.javarush.mogutov.cryptoanalizer.constants.Constants.*;

public class Analyzer{

    // function for text encryption
    void encryptText(ArrayList<Character> text, int move){

        for (Character character : text) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if (Objects.equals(character, ALPHABET[j])) {
                    try {
                        EncryptText.append(ALPHABET[j + move]);
                        break;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        int indexOutBounds = move - (32 - j);
                        EncryptText.append(ALPHABET[indexOutBounds - 1]);
                        break;
                    }
                }
            }
        }
    }

    void decryptText(ArrayList<Character> text, int move){

        for (int i = 0; i < text.size(); i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if (Objects.equals(text.get(i), ALPHABET[j])) {
                    EncryptText.append(ALPHABET[j - move]);
                    break;
                }
            }
        }

        //                    try {
//                        EncryptText.append(ALPHABET[j - move]);
//                        break;
//                    } catch (ArrayIndexOutOfBoundsException e) {
//                        int indexOutBounds = move - (32 - j);
//                        EncryptText.append(ALPHABET[indexOutBounds - 1]);
//                        break;
//                    }
//        StringBuilder cryptText = new StringBuilder();
//        char[] inputChar = input.toCharArray();
//
//
//        for (int i = 0; i < inputChar.length; i++) {
//            for (int j = 0; j < ALPHABET.length; j++) {
//                if(inputChar[i] == ALPHABET[j]){
//                    try {
//                        cryptText.append(ALPHABET[j - move]);
//                        break;
//                    } catch (ArrayIndexOutOfBoundsException e){
//                        int indexOutBounds = move - j;
//                        cryptText.append(ALPHABET[ALPHABET.length - indexOutBounds]);
//                        break;
//                    }
//                }
//            }
//        }
       // return cryptText;
    }

    void readPunctuation(ArrayList<Character> text){
        // we remember the place (index) of punctuation and its meaning (symbol)
        for (int i = 0; i < text.size(); i++) {
            for (char c : PUNCTUATION) {
                if (text.get(i) == c) {
                    punctuationMap.put(i, text.get(i));
                }
            }
        }

    }

    StringBuilder writePunctuation(StringBuilder textWithoutPunctuation){

        // buffer LIST for writing text With punctuation
        ArrayList<Character> symbolChar = new ArrayList<>();
        // indexes to be added (in place of key) to the value (values)
        Set<Integer> keys = punctuationMap.keySet();

        for (int i = 0; i < textWithoutPunctuation.length(); i++){
                symbolChar.add(textWithoutPunctuation.charAt(i));
        }

//            if(Character.isAlphabetic(textWithoutPunctuation.charAt(i))) {
//                symbolChar.add(textWithoutPunctuation.charAt(i));
//            }

        // adding punctuation
        for (Integer key : keys) {
            char value = punctuationMap.get(key);
            //symbolChar.add(key, value);
            try {
                symbolChar.add(key, value);
            }catch (IndexOutOfBoundsException e){
                symbolChar.add(value);
            }
        }

//            try {
//                symbolChar.add(key, value);
//            }catch (IndexOutOfBoundsException e){
//                symbolChar.add(key-2, value);
//            }

        // adding to the new StringBuilder
        StringBuilder textWithPunctuation = new StringBuilder("");
        for (char symbol : symbolChar) {
            textWithPunctuation.append(symbol);
        }
        return textWithPunctuation;
    }

    void deletePunctuation(ArrayList<Character> text){

        // list, where we write the indexes that should be deleted
        List<Integer> indexNeedToDelete = new ArrayList<>();

        // writing down the indexes that should be deleted
        for (int i = 0; i < text.size(); i++) {
            for (char c : PUNCTUATION) {
                if (text.get(i).equals(c)) {
                    indexNeedToDelete.add(i);
                    break;
                }
            }
        }

        // delete punctuation
        for (int i = 0; i < indexNeedToDelete.size(); i++) {
            text.remove(indexNeedToDelete.get(i));
            //text.remove(indexNeedToDelete.get(i) - i);
        }

    }

}
