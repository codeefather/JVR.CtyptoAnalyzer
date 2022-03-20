package ru.javarush.mogutov.cryptoanalizer.commands;

import ru.javarush.mogutov.cryptoanalizer.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
