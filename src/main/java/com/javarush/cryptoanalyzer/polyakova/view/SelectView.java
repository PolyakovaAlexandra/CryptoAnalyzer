package com.javarush.cryptoanalyzer.polyakova.view;

import com.javarush.cryptoanalyzer.polyakova.exception.ApplicationException;

import java.util.Scanner;

public class SelectView {

    public View selectView () {
        View view;
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("Введите 1 для продолжения работы в консоли или 2 для работы в GUI:");
            String typeOfView=scanner.nextLine();
            if (typeOfView.equalsIgnoreCase("1")) {
                view = new ConsoleView();
                break;
            } else if (typeOfView.equalsIgnoreCase("2")) {
                view = new GUIView();
                break;
            }
            else System.out.println("Введи число 1 или 2!");
        }
        return view;
    }
}
