package com.javarush.cryptoanalyzer.polyakova.repository;

import com.javarush.cryptoanalyzer.polyakova.services.Decode;
import com.javarush.cryptoanalyzer.polyakova.services.Encode;
import com.javarush.cryptoanalyzer.polyakova.services.Function;
import com.javarush.cryptoanalyzer.polyakova.services.BruteForce;

public enum FunctionCode {
    ENCODE(new Encode()),DECODE(new Decode()), BRUTE_FORCE(new BruteForce());
    private Function function;

    public Function getFunction() {
        return function;
    }

    FunctionCode(Function function) {
        this.function = function;
    }
}
