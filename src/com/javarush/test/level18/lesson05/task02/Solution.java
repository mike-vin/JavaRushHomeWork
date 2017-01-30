package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;

public class Solution {
    private static final char SYMBOL = ',';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bufferedReader.readLine();
        File sourceFile = new File(filePath);
        if (!sourceFile.exists() || !sourceFile.canRead()) return;
        FileReader fileReader = new FileReader(sourceFile);
        int count = 0;
        int temp = 0;
        while ((temp = fileReader.read()) > 0)
            if ((char) temp == SYMBOL) count++;
        System.out.println(count);
        bufferedReader.close();
        fileReader.close();
    }
}
