package com.javarush.cryptoanalyzer.polyakova.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CryptoAlphabet {
        public static final char[] ALPHABET_LOWER_CASE = {'а', 'б', 'в', 'г', 'д', 'е','ё', 'ж', 'з',
                'и','й','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                'ъ', 'ы', 'ь', 'э','ю','я'};
        public static final char[] ALPHABET_UPPER_CASE = {'А', 'Б', 'В', 'Г', 'Д', 'Е','Ё', 'Ж', 'З',
                'И','Й','К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
                'Ъ', 'Ы', 'Ь', 'Э', 'Ю','Я'};
        public static final char[] DIGITS = {'0','1','2','3','4','5','6','7','8','9'};
        public static final char[] SYMBOLS = { '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

        public static final char[] ALPHABET_COMMON= {'а', 'б', 'в', 'г', 'д', 'е','ё', 'ж', 'з',
                'и','й','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                'ъ', 'ы', 'ь', 'э','ю','я','А', 'Б', 'В', 'Г', 'Д', 'Е','Ё', 'Ж', 'З',
                'И','Й','К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
                'Ъ', 'Ы', 'Ь', 'Э', 'Ю','Я','0','1','2','3','4','5','6','7','8','9','.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

      /* public static void main(String[] args) {
                System.arraycopy(ALPHABET_LOWER_CASE,0,ALPHABET_COMMON,0,ALPHABET_LOWER_CASE.length);
                System.arraycopy(ALPHABET_UPPER_CASE,0,ALPHABET_COMMON,ALPHABET_LOWER_CASE.length,ALPHABET_UPPER_CASE.length);
                System.arraycopy(DIGITS,0,ALPHABET_COMMON,ALPHABET_LOWER_CASE.length+ALPHABET_UPPER_CASE.length,DIGITS.length);
                System.arraycopy(SYMBOLS,0,ALPHABET_COMMON,ALPHABET_LOWER_CASE.length+ALPHABET_UPPER_CASE.length+DIGITS.length,SYMBOLS.length);
               for (char c : ALPHABET_COMMON) {
                       System.out.print(c+" ");
               }
       }*/






}
