package com.javarush.cryptoanalyzer.polyakova.view;

import com.javarush.cryptoanalyzer.polyakova.entity.Result;

public interface View {

    String[] getParameters();
    void printResults(Result result);
}
