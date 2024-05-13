package com.javarush.cryptoanalyzer.polyakova.view;

import com.javarush.cryptoanalyzer.polyakova.EntryPoint;
import com.javarush.cryptoanalyzer.polyakova.entity.Result;

import java.util.Scanner;

import static com.javarush.cryptoanalyzer.polyakova.constant.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.cryptoanalyzer.polyakova.constant.ApplicationCompletionConstants.SUCCESS;

public class ConsoleView implements View {
    Scanner scanner = new Scanner(System.in);
    String[] parameters = new String[2];

    @Override
    public String[] getParameters() {
//        TODO logic work with console, finish method
        System.out.println("Введите:\n 1 для кодировки, \n 2 для декодировки, \n 3 для решения через Brute force");
        parameters[1]=scanner.nextLine();
        return new String[]{parameters[1]};
    }

    @Override
    public void printResults(Result result) {
        switch (result.getResultCode()) {
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION+result.getApplicationException().getMessage());
        }
        }
    }

