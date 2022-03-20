package ru.javarush.mogutov.cryptoanalizer;

import ru.javarush.mogutov.cryptoanalizer.entity.Controller;

import static ru.javarush.mogutov.cryptoanalizer.constants.Constants.*;

public class Application {
    public static void main(String[] args) {
        createApp();
    }

    public static void createApp(){
        console.run();
        controller = new Controller();
    }

}
