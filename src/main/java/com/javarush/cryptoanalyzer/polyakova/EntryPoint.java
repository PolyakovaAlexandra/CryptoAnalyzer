package com.javarush.cryptoanalyzer.polyakova;

import com.javarush.cryptoanalyzer.polyakova.app.Application;
import com.javarush.cryptoanalyzer.polyakova.controller.MainController;
import com.javarush.cryptoanalyzer.polyakova.entity.Result;
import com.javarush.cryptoanalyzer.polyakova.view.ConsoleView;
import com.javarush.cryptoanalyzer.polyakova.view.GUIView;
import com.javarush.cryptoanalyzer.polyakova.view.SelectView;
import com.javarush.cryptoanalyzer.polyakova.view.View;

import java.util.Scanner;

public class EntryPoint {
    public static void main(String[] args) {


        SelectView selectView = new SelectView();
        View view = selectView.selectView();

        MainController mainController = new MainController(view);
        Application application = new Application(mainController);

        Result result = application.run();
        application.printResult(result);
    }


}