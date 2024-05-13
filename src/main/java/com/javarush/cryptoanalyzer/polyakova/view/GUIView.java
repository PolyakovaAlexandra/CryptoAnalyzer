package com.javarush.cryptoanalyzer.polyakova.view;

import com.javarush.cryptoanalyzer.polyakova.entity.Result;

import static com.javarush.cryptoanalyzer.polyakova.constant.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.cryptoanalyzer.polyakova.constant.ApplicationCompletionConstants.SUCCESS;

public class GUIView implements View {

    @Override
    public String[] getParameters() {
//        TODO finish this method
        return new String[1];
    }

    @Override
    public void printResults(Result result) {
        switch (result.getResultCode()) {
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION+result.getApplicationException().getMessage());
        }
    }
}
