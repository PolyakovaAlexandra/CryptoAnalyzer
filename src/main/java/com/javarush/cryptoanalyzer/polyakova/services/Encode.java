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

public class Encode implements Function {
    @Override
    public Result execute(String[] parameters) {
        List<Character> characterList = new ArrayList<Character>();
        // Сделать отдельный класс с методами для ввода адреса файла
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите адрес файла, который нужно зашифровать, либо нажмите ENTER для тестового запуска программы:");
            parameters[0] = scanner.nextLine();
            if (parameters[0].equalsIgnoreCase("")) {
                parameters[0] = "C:\\Users\\-sSs-\\IdeaProjects\\InputTest.txt";
            }
            PathValidator pathValidator = new PathValidator();
            if (pathValidator.pathValidator(parameters[0])) {
                //дать лист куда записываем данные чтоб не перезаписывать!
                InputData inputData = new InputData();
                inputData.readFile(parameters[0], characterList);
                break;
            }
            else System.out.println("Некорректный адрес, попробуйте снова!");}
        String dest;
        while (true) {
            System.out.println("Введите адрес файла, в который сохранить зашифрованный текст, либо нажмите ENTER для тестового запуска программы:");
            parameters[0] = scanner.nextLine();
             dest=parameters[0];
            if (dest.equalsIgnoreCase("")) {
                dest = "C:\\Users\\-sSs-\\IdeaProjects\\OutputTest.txt";
            }
            PathValidator pathValidator = new PathValidator();
            if (pathValidator.pathValidator(dest)) {
                break;
            }
            else System.out.println("Некорректный адрес, попробуйте снова!");}

        int ceasarKey;
        while (true) {
            System.out.println("Введите ключ Цезаря, либо нажмите ENTER для тестового запуска программы:");
            parameters[0] = scanner.nextLine();
            String key = parameters[0];
            if (key.equalsIgnoreCase("")) {
                key = "10";
            }
            String regex = "[0-9]+";
            if (key.matches(regex)){
            ceasarKey= Integer.parseInt(key)%(ALPHABET_COMMON.length);
            break;}
            else System.out.println("Ключ должен состоять только из числа, попробуйте снова!");
        }
//          TODO finish encode execute method кодировки код вернуть результат ок или эррор
       try (FileWriter writer = new FileWriter(dest)) {
           List<Integer> numb = new ArrayList<Integer>();
           List<Character> copyList = new ArrayList<Character>();
           for (Character c : characterList) {
               for (int i = 0; i < ALPHABET_COMMON.length; i++) {
                   if (c.compareTo(ALPHABET_COMMON[i])==0){
                       numb.add(i);
                   }
               }
           }
           for (Integer n : numb) {
               copyList.add(ALPHABET_COMMON[(n+ceasarKey)%ALPHABET_COMMON.length]);
           }

           {
               char[] buffer = new char[65536]; // 128Kb
               for (Character c : copyList) {
                   writer.write(c);
               }

           }


       }
        catch (Exception e){
           return new Result(ResultCode.ERROR,new ApplicationException("Decode operation finish with exception", e));
        }
        return new Result(ResultCode.OK);
    }
}

