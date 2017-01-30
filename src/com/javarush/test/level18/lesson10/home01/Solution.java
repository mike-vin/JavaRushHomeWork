package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки.
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

        int countOfEnglishChars = getCountOfEnglishChars(stringBuilder.toString());
        System.out.println(countOfEnglishChars);
    }

    private static int getCountOfEnglishChars(String word) {
        int count = 0;
        char[] charsOfWord = word.toCharArray();
        for (char c : charsOfWord)
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                count++;
        return count;
    }
}
