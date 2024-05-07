package com.javarush.cryptoanalyzer.polyakova.constant;

public class CryptoAlphabet {
        private static final char[] ALPHABET_LOWER_CASE = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
                'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                'ъ', 'ы', 'ь', 'э','ю','я'};
        private static final char[] ALPHABET_UPPER_CASE = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
                'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                'ъ', 'ы', 'ь', 'э', 'я'};
        private static final char[] DIGITS = {'0','1','2','3','4','5','6','7','8','9'};
        private static final char[] SYMBOLS = { '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

        private static final char[] ALPHABET=new char[ALPHABET_LOWER_CASE.length+ALPHABET_UPPER_CASE.length+
                DIGITS.length+SYMBOLS.length];

        public static void main(String[] args) {
                System.arraycopy(ALPHABET_LOWER_CASE,0,ALPHABET,ALPHABET_LOWER_CASE.length);
                System.arraycopy(ALPHABET_UPPER_CASE,ALPHABET_LOWER_CASE.length,ALPHABET,ALPHABET_UPPER_CASE.length);
                System.arraycopy(DIGITS,0,ALPHABET,ALPHABET_LOWER_CASE.length+ALPHABET_UPPER_CASE.length);
                System.arraycopy(SYMBOLS,0,ALPHABET,ALPHABET_LOWER_CASE+ALPHABET_UPPER_CASE+DIGITS);
        }


}
