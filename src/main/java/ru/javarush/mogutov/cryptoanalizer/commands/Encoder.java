package ru.javarush.mogutov.cryptoanalizer.commands;

import static ru.javarush.mogutov.cryptoanalizer.constants.Constants.*;
public class Encoder implements Action{

    Analyzer analyzer;

    public Encoder(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    @Override
    public void execute() {
        analyzer.readPunctuation(TEXT);
        analyzer.deletePunctuation(TEXT);
        analyzer.encryptText(TEXT, keyToEncrypt);
        EncryptText = analyzer.writePunctuation(EncryptText);
    }

}
