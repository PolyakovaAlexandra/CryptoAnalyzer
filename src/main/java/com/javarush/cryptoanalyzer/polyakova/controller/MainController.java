package com.javarush.cryptoanalyzer.polyakova.controller;

import com.javarush.cryptoanalyzer.polyakova.view.View;

public class MainController {
    private View view;

    public MainController(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
