package ru.javarush.mogutov.cryptoanalizer.constants;

import ru.javarush.mogutov.cryptoanalizer.ConsoleRunner;
import ru.javarush.mogutov.cryptoanalizer.entity.Controller;

import java.util.ArrayList;
import java.util.TreeMap;


public class Constants {
    public static final char[] ALPHABET = new char[]{
            'А', 'Б', 'В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н',
            'О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я',
            'а', 'б', 'в','г','д','е','ё','ж','з','и','й','к','л','м','н',
            'о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
    public static final char[] PUNCTUATION = new char[]{
            ' ', '\n', '\r', '.', ',', '«', '»', '\'', '\"', ':', ';', '!', '?', '(', ')',
            '[', ']', '{', '}', '_','+', '=', '\\', '—', '*', '-', '№', '…', '@', '/','<','>', '-',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static TreeMap<Integer, Character> punctuationMap = new TreeMap<>();
    public static String FileAddressToRead;
    public static String FileAddressToWrite;
    public static int keyToEncrypt;
    public static int keyToDeCrypt;
    public static int userChoiceNumber;
    public static ConsoleRunner console = new ConsoleRunner();
    public static Controller controller;
    public static StringBuilder EncryptText = new StringBuilder();
    public static ArrayList<Character> TEXT = new ArrayList<>();
}
