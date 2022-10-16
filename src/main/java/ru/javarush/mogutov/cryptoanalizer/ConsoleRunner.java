package ru.javarush.mogutov.cryptoanalizer;

import java.util.Scanner;
import static ru.javarush.mogutov.cryptoanalizer.constants.Constants.*;

public class ConsoleRunner {

    Scanner scanner = new Scanner(System.in);;
    public ConsoleRunner() {}

    void run(){
        System.out.println("Welcome to CryptoAnalyzer");
        System.out.println("Please enter the address file");
        FileAddressToRead = scanner.nextLine();
        //FileAddressToRead = "D:\\test\\encrypt.txt";
        System.out.println("Enter address file to write result");
        //FileAddressToWrite = "D:\\test\\decrypt.txt";
        FileAddressToWrite = scanner.nextLine();
        userChoice();
    }

    void userChoice() {
        System.out.println("OK...");
        System.out.println("The application can:");
        System.out.println("1. Encrypt the text of the file");
        System.out.println("2. Decryption with a known key");
        System.out.println("3. Decryption by brute force method");
        System.out.println("4. Decoding by the method of statistical analysis");
        System.out.println("Please select the mode");

        userChoiceNumber = scanner.nextInt();

        switch(userChoiceNumber){
            case 1:
                System.out.println("Enter your key for encrypt text");
                keyToEncrypt= scanner.nextInt();
                break;
            case 2:
                System.out.println("Enter your key for decryption");
                keyToDeCrypt = scanner.nextInt();
                break;
            case 3:
                System.out.println("Brute force currently not available");
            case 4:
                System.out.println("Currently not available");
        }
    }
}
