package com.javarush.test.level18.lesson03.task05;

import java.io.*;
import java.util.*;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.

Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = consoleReader.readLine();
        File file = new File(filePath);
        if (!file.exists() && !file.canRead()) return;

        ArrayList<Integer> arrayList = new ArrayList<>();
        InputStream fileReader = new FileInputStream(file);
        while (fileReader.available() > 0) {
            int byteKey = fileReader.read();
            if (!arrayList.contains(byteKey)) arrayList.add(byteKey);
        }
        Collections.sort(arrayList);
        String result = "";
        for (Integer intValue : arrayList) result = result + intValue + " ";

        System.out.println(result.trim());

        consoleReader.close();
        fileReader.close();
    }
}