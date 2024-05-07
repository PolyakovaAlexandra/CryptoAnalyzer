package com.javarush.cryptoanalyzer.polyakova.view;

import com.javarush.cryptoanalyzer.polyakova.entity.Result;

import static com.javarush.cryptoanalyzer.polyakova.constant.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.cryptoanalyzer.polyakova.constant.ApplicationCompletionConstants.SUCCESS;

public class ConsoleView implements View {
    @Override
    public String[] getParameters() {
//        TODO logic work with console, finish method
        return new String[0];
    }

    @Override
    public void printResults(Result result) {
        switch (result.getResultCode()) {
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION+result.getApplicationException().getMessage());
        }
        }
    }
}
