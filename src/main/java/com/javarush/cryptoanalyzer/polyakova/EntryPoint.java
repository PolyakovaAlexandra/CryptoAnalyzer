package com.javarush.cryptoanalyzer.polyakova;

import com.javarush.cryptoanalyzer.polyakova.app.Application;
import com.javarush.cryptoanalyzer.polyakova.controller.MainController;
import com.javarush.cryptoanalyzer.polyakova.entity.Result;
import com.javarush.cryptoanalyzer.polyakova.view.ConsoleView;
import com.javarush.cryptoanalyzer.polyakova.view.GUIView;
import com.javarush.cryptoanalyzer.polyakova.view.View;

import java.util.Scanner;

public class EntryPoint {
    public static void main(String[] args) {
        View view;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите 1 для продолжения работы в консоли или 2 для работы в GUI:");
        String selectView=scanner.nextLine();
        if (selectView.equalsIgnoreCase("1")) {
            view = new ConsoleView();
        }else{
            view = new GUIView();}
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);

        Result result = application.run();
        application.printResult(result);
    }
}