package ru.javarush.mogutov.cryptoanalizer.entity;

import ru.javarush.mogutov.cryptoanalizer.commands.Analyzer;
import ru.javarush.mogutov.cryptoanalizer.commands.Encoder;

import java.io.FileReader;
import java.io.FileWriter;


import static ru.javarush.mogutov.cryptoanalizer.constants.Constants.*;


public class Controller {

    public Controller() {
        startMove();
    }

    public static void startMove(){
        startReadFile();
        runCommand();
        startWriteFile();
    }

    public static void startReadFile(){
        try (FileReader reader = new FileReader(FileAddressToRead)) {
            StringBuilder bufferText = new StringBuilder();
            while (reader.ready()) {
                char c = (char) reader.read();
                bufferText.append(c);
            }
            if (bufferText.length() > 0) {
                for (int i = 0; i < bufferText.length(); i++) {
                    TEXT.add(bufferText.charAt(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startWriteFile(){

        try(FileWriter writer = new FileWriter(FileAddressToWrite)){
            for (int i = 0; i < EncryptText.length(); i++) {
                writer.write(EncryptText.charAt(i));
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void runCommand(){
        switch(userChoiceNumber){
            case 1:
                Encoder encoder = new Encoder(new Analyzer());
                encoder.execute();
                break;
            case 2:
                //controller = new Controller(keyToDeCrypt);
                break;
            case 3:
                System.out.println("Brute force currently not available");
            case 4:
                System.out.println("Currently not available");
        }
    }
}
