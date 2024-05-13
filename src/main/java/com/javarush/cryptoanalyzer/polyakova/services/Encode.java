package com.javarush.cryptoanalyzer.polyakova.services;

import com.javarush.cryptoanalyzer.polyakova.entity.Result;
import com.javarush.cryptoanalyzer.polyakova.exception.ApplicationException;
import com.javarush.cryptoanalyzer.polyakova.repository.ResultCode;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static com.javarush.cryptoanalyzer.polyakova.constant.CryptoAlphabet.ALPHABET_COMMON;
import static com.javarush.cryptoanalyzer.polyakova.constant.InformationForUser.*;

public class Encode implements Function {
    @Override
    public Result execute(String[] parameters) {
        List<Character> inputCharacterList = new ArrayList<Character>();

        InputData inputData = new InputData();

        inputData.ReadingInputFile(INPUT_FILE_PATH_ENCODE,INPUT_TEST_FILE_PATH_ENCODE, inputCharacterList);

        String dest = inputData.ReadingOutputFile(OUTPUT_FILE_PATH_ENCODE,OUTPUT_TEST_FILE_PATH_ENCODE);

        int ceasarKey = inputData.ReadingCeasarCode(INPUT_VALUE_OF_CEASAR_CODE, TEST_CEASAR_CODE);

       try (FileWriter writer = new FileWriter(dest)) {
           List<Integer> charsPosition = new ArrayList<Integer>();
           List<Character> outputCharacterList = new ArrayList<Character>();
           for (Character c : inputCharacterList) {
               for (int i = 0; i < ALPHABET_COMMON.length; i++) {
                   if (c.compareTo(ALPHABET_COMMON[i])==0){
                       charsPosition.add(i);
                   }
               }
           }
           for (Integer i : charsPosition) {
               outputCharacterList.add(ALPHABET_COMMON[(i+ceasarKey)%ALPHABET_COMMON.length]);
           }
           for (Character c : outputCharacterList) {
                   writer.write(c);
               }
       } catch (Exception e){
           return new Result(ResultCode.ERROR,new ApplicationException("Encode operation finish with exception", e));
        }
        return new Result(ResultCode.OK);
    }
}

