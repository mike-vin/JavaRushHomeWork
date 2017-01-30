package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки.
*/

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filepath = /*"C:\\Users\\Mike\\Desktop\\test.txt";//*/ args[0];
        File destinationFile = new File(filepath);

        if (!destinationFile.canRead()) return;

        FileReader fileReader = new FileReader(destinationFile);
        int data = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while ((data = fileReader.read()) > -1) stringBuilder.append((char) data);
        fileReader.close();

        int total = stringBuilder.toString().length();
        int spaces = getCountSpaces(stringBuilder.toString());
        float ratio = (float) ((double) spaces / (double) total) * 100;
        System.out.printf("%.2f", ratio);
    }

    private static int getCountSpaces(String string) {
        char[] chars = string.toCharArray();
        int countSpaces = 0;
        for (char aChar : chars)
            if (' ' == aChar) countSpaces++;
        return countSpaces;
    }

}
