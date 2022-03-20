package ru.javarush.mogutov.cryptoanalizer.commands;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static ru.javarush.mogutov.cryptoanalizer.constants.Constants.*;

public class Analyzer{

    void encryptText(ArrayList<Character> text, int move){

        for (int i = 0; i < text.size(); i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if(Objects.equals(text.get(i), ALPHABET[j])){
                    try {
                        EncryptText.append(ALPHABET[j + move]);
                        break;
                    } catch (ArrayIndexOutOfBoundsException e){
                        int indexOutBounds = move - (32-j);
                        EncryptText.append(ALPHABET[indexOutBounds - 1]);
                        break;
                    }
                }
            }
        }

    }

    StringBuilder decryptText(String input, int move){
        StringBuilder cryptText = new StringBuilder();
        char[] inputChar = input.toCharArray();


        for (int i = 0; i < inputChar.length; i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if(inputChar[i] == ALPHABET[j]){
                    try {
                        cryptText.append(ALPHABET[j - move]);
                        break;
                    } catch (ArrayIndexOutOfBoundsException e){
                        int indexOutBounds = move - j;
                        cryptText.append(ALPHABET[ALPHABET.length - indexOutBounds]);
                        break;
                    }
                }
            }
        }
        return cryptText;
    }

    void readPunctuation(ArrayList<Character> text){
        // запоминаем место (индекс) пунктуации и его значение(символ)
        for (int i = 0; i < text.size(); i++) {
            for (int j = 0; j < PUNCTUATION.length; j++) {
                if(text.get(i) == PUNCTUATION[j]){
                    punctuationMap.put(i, text.get(i));
                }
            }
        }

    }

    StringBuilder writePunctuation(StringBuilder textWithoutPunctuation){

        // буфферный LIST для записи текста С пунктуацией
        List<Character> symbolChar = new ArrayList<>();
        // индексы, которые надо добавить (на место key) на значение (values)
        Set<Integer> keys = punctuationMap.keySet();

        // Добавляем наш тект без пунктуации в ArrayList
        for (int i = 0; i < textWithoutPunctuation.length(); i++){
            if(Character.isAlphabetic(textWithoutPunctuation.charAt(i))) {
                symbolChar.add(textWithoutPunctuation.charAt(i));
            }
        }

        // добавляем пунктуацию
        for (Integer key : keys) {
            char value = punctuationMap.get(key);
            symbolChar.add(key, value);
        }

        // добавляем в новый StringBuilder
        StringBuilder textWithPunctuation = new StringBuilder("");
        for (char symbol : symbolChar) {
            textWithPunctuation.append(symbol);
        }
        return textWithPunctuation;
    }

    void deletePunctuation(ArrayList<Character> text){

        // list, куда записываем индексы, которые следует удалить
        List<Integer> indexNeedToDelete = new ArrayList<>();

        // записываем индексы, которые следует удалить
        for (int i = 0; i < text.size(); i++) {
            for (char c : PUNCTUATION) {
                if (text.get(i).equals(c)) {
                    indexNeedToDelete.add(i);
                }
            }
        }

        // удаляем пунктуацию
        for (int i = 0; i < indexNeedToDelete.size(); i++) {
            text.remove(indexNeedToDelete.get(i) - i);
        }

    }

}
