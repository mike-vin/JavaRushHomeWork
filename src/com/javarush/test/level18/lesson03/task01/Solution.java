package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        File source = new File(fileName);
        if (!source.exists() && !source.canRead()) return;

        FileInputStream fileStream = new FileInputStream(source);
        int max = 0;
        int tmp;

        while (fileStream.available() > 0) if ((tmp = fileStream.read()) > max) max = tmp;
        System.out.println(max);

        reader.close();
        fileStream.close();
    }
}
// C:\Users\Mike\Desktop