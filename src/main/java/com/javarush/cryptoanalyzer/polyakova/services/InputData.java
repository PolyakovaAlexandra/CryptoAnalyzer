package com.javarush.cryptoanalyzer.polyakova.services;

import com.javarush.cryptoanalyzer.polyakova.exception.ApplicationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.javarush.cryptoanalyzer.polyakova.constant.CryptoAlphabet.ALPHABET_COMMON;
import static com.javarush.cryptoanalyzer.polyakova.constant.InformationForUser.INPUT_FILE_PATH_ENCODE;
import static com.javarush.cryptoanalyzer.polyakova.constant.InformationForUser.INPUT_TEST_FILE_PATH_ENCODE;


public class InputData {
    Scanner scanner = new Scanner(System.in);
    PathValidator pathValidator = new PathValidator();

    public void ReadingInputFile(final String introductoryInputPhrase, final String testInputPath,  List<Character> inputDataList) {

        while (true) {
            System.out.println(introductoryInputPhrase);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("")) {
                input= testInputPath;
            }
            if (pathValidator.pathValidator(input)) {
                readFile(input, inputDataList);
                break;
            } else System.out.println("Некорректный адрес, попробуйте снова!");
        }
    }

    public List<Character> readFile(String src, List<Character> inputData) {
        try (Reader reader = new FileReader(src)) {
            char[] buffer = new char[1024];
            while (reader.ready()) {
                int amount = reader.read(buffer);
                for (int i = 0; i < amount; i++) {
                    inputData.add(buffer[i]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new ApplicationException("Error with reading information in file: ", e);
        } catch (IOException e) {
            throw new ApplicationException("Error with reading information in file: ", e);
        }
        return inputData;
    }

    public String ReadingOutputFile(final String introductoryOutputPhrase, final String testOutputPath) {
        String output;
        while (true) {
            System.out.println(introductoryOutputPhrase);
            output= scanner.nextLine();
            if (output.equalsIgnoreCase("")) {
                output = testOutputPath;
            }
            if (pathValidator.pathValidator(output)) {
                break;
            } else System.out.println("Некорректный адрес, попробуйте снова!");
        }
        return output;
    }

    public int ReadingCeasarCode(final String introductoryCeasarPhrase, final String testKeyValue) {
        int ceasarKey;
        while(true) {
        System.out.println(introductoryCeasarPhrase);
        String key = scanner.nextLine();
        if (key.equalsIgnoreCase("")) {
            key =testKeyValue;
        }
        String regex = "[0-9]+";
        if (key.matches(regex)) {
            ceasarKey = Integer.parseInt(key) % (ALPHABET_COMMON.length);
            break;
        } else System.out.println("Ключ должен состоять только из числа, попробуйте снова!");
    }
    return ceasarKey;
}

}
