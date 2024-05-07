package com.javarush.cryptoanalyzer.polyakova;

import com.javarush.cryptoanalyzer.polyakova.app.Application;
import com.javarush.cryptoanalyzer.polyakova.controller.MainController;
import com.javarush.cryptoanalyzer.polyakova.entity.Result;
import com.javarush.cryptoanalyzer.polyakova.view.ConsoleView;
import com.javarush.cryptoanalyzer.polyakova.view.View;

public class EntryPoint {
    public static void main(String[] args) {

        View view = new ConsoleView();
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);

        Result result = application.run();
        application.printResult(result);
    }
}