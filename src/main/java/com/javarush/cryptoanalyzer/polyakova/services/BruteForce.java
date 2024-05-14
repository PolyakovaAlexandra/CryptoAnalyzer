package com.javarush.cryptoanalyzer.polyakova.services;

import com.javarush.cryptoanalyzer.polyakova.entity.Result;
import com.javarush.cryptoanalyzer.polyakova.exception.ApplicationException;
import com.javarush.cryptoanalyzer.polyakova.repository.ResultCode;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.javarush.cryptoanalyzer.polyakova.constant.CryptoAlphabet.ALPHABET_COMMON;
import static com.javarush.cryptoanalyzer.polyakova.constant.InformationForUser.*;


public class BruteForce implements Function {
    @Override
    public Result execute(String[] parameters) {
        List<Character> inputCharacterList = new ArrayList<Character>();

        InputData inputData = new InputData();

        inputData.ReadingInputFile(INPUT_FILE_PATH_DECODE,INPUT_TEST_FILE_PATH_BRUTE_FORCE, inputCharacterList);

        String dest = inputData.ReadingOutputFile(OUTPUT_FILE_PATH_DECODE,OUTPUT_TEST_FILE_PATH_BRUTE_FORCE);

        try (FileWriter writer = new FileWriter(dest)) {
            List<Integer> charsPosition = new ArrayList<Integer>();
            List<String> outputStringList = new ArrayList<String>();
            String s=null;
            for (Character c : inputCharacterList) {
                for (int i = 0; i < ALPHABET_COMMON.length; i++) {
                    if (c.compareTo(ALPHABET_COMMON[i])==0){
                        charsPosition.add(i);
                    }
                }
            }

            for (int i = 0; i < ALPHABET_COMMON.length; i++) {
                for (Integer position : charsPosition) {
                     s+=String.valueOf(ALPHABET_COMMON[(position-i+ALPHABET_COMMON.length)%ALPHABET_COMMON.length]);
                }
                outputStringList.add(s);
                s=null;
            }

            String regex ="((^[а-яёА-ЯЁ][^\\d])([а-яё]{0,12})\\s)(([а-яё][^\\d]*[\\s\\S][а-яё]{0,12})*$)";
            Pattern pattern = Pattern.compile(regex);

            for (String line : outputStringList) {
                if (line.matches(regex)) {
                    writer.write(line);
                }
            }
        }catch (Exception e){
            return new Result(ResultCode.ERROR,new ApplicationException("Brute Force operation finish with exception", e));
        }
        return new Result(ResultCode.OK);
    }
}

