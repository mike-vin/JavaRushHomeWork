package com.javarush.test.level18.lesson03.task02;

import java.io.*;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bufferedReader.readLine();
        File sourceFile = new File(filePath);
        if (!sourceFile.exists() && !sourceFile.canRead()) return;

        FileInputStream inputStream = new FileInputStream(sourceFile);
        int minValue = Integer.MAX_VALUE;
        int temp;
        while (inputStream.available() > 0)
            if ((temp = inputStream.read()) < minValue) minValue = temp;
        System.out.println(minValue);
        bufferedReader.close();
        inputStream.close();
    }
}