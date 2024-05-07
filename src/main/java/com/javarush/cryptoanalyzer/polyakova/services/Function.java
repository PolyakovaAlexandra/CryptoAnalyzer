package com.javarush.cryptoanalyzer.polyakova.services;

import com.javarush.cryptoanalyzer.polyakova.entity.Result;

public interface Function {
    Result execute(String[] parameters);
}
