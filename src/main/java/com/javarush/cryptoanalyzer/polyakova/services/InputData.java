package com.javarush.cryptoanalyzer.polyakova.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class InputData {
    public List<Character> readFile (String src, List<Character> inputData){
        try (Reader reader = new FileReader(src)) {
            char[] buffer = new char[1024];
            while (reader.ready()){
                int amount = reader.read(buffer);
                for (int i = 0; i < amount; i++) {
                    inputData.add(buffer[i]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inputData;
    }

}
