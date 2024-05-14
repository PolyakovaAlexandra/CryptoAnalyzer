package com.javarush.cryptoanalyzer.polyakova.view;

import com.javarush.cryptoanalyzer.polyakova.EntryPoint;
import com.javarush.cryptoanalyzer.polyakova.entity.Result;

import java.util.Scanner;

import static com.javarush.cryptoanalyzer.polyakova.constant.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.cryptoanalyzer.polyakova.constant.ApplicationCompletionConstants.SUCCESS;

public class ConsoleView implements View {
    Scanner scanner = new Scanner(System.in);
    String[] parameters = new String[1];

    @Override
    public String[] getParameters() {
        String parameters;
        while (true){
        System.out.println("Введите:\n 1 - для кодировки, \n 2 - для декодировки, \n 3 - для решения через Brute force");
            parameters=scanner.nextLine();
        if (parameters.equalsIgnoreCase("1")
                ||parameters.equalsIgnoreCase("2")
                    ||parameters.equalsIgnoreCase("3"))
        {
            break;
        }
        else System.out.println("Введи число согласно условию!");
        }
        return new String[]{parameters};
    }

    @Override
    public void printResults(Result result) {
        switch (result.getResultCode()) {
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION+result.getApplicationException().getMessage());
        }
        }
    }

