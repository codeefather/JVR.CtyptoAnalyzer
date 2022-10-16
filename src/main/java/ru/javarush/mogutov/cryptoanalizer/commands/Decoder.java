package ru.javarush.mogutov.cryptoanalizer.commands;

import static ru.javarush.mogutov.cryptoanalizer.constants.Constants.*;
import static ru.javarush.mogutov.cryptoanalizer.constants.Constants.EncryptText;

public class Decoder implements Action{

    Analyzer analyzer;

    public Decoder(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    @Override
    public void execute() {
        analyzer.readPunctuation(TEXT);
        analyzer.deletePunctuation(TEXT);
        analyzer.decryptText(TEXT, keyToDeCrypt);
        EncryptText = analyzer.writePunctuation(EncryptText);
    }


}
