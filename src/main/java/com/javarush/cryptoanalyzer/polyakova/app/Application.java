package com.javarush.cryptoanalyzer.polyakova.app;

import com.javarush.cryptoanalyzer.polyakova.controller.MainController;
import com.javarush.cryptoanalyzer.polyakova.entity.Result;
import com.javarush.cryptoanalyzer.polyakova.repository.FunctionCode;
import com.javarush.cryptoanalyzer.polyakova.services.Function;

import static com.javarush.cryptoanalyzer.polyakova.constant.FunctionCodeConstants.*;

public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }

    public Result run(){
        String[] parameters = mainController.getView().getParameters();
        String mode=parameters[0];
        Function function = getFunction(mode);
        return function.execute(parameters);
    }

    private Function getFunction(String mode){
        return switch (mode){
            case "1" -> FunctionCode.valueOf(ENCODE).getFunction();
            case "2" -> FunctionCode.valueOf(DECODE).getFunction();
            default -> FunctionCode.valueOf(UNSUPPORTED_FUNCTION).getFunction();

        };
    }
    public void printResult(Result result){
        mainController.getView().printResults(result);
    }
}
