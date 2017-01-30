package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:

Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки.

/home/mike/Рабочий стол/test
/home/mike/Рабочий стол/file1
/home/mike/Рабочий стол/file2
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath1 = bufferedReader.readLine();
        String filePath2 = bufferedReader.readLine();
        String filePath3 = bufferedReader.readLine();

        FileInputStream fileReader = new FileInputStream(filePath1);
        FileOutputStream outputStream1 = new FileOutputStream(filePath2);
        FileOutputStream outputStream2 = new FileOutputStream(filePath3);

        int fileLength = fileReader.available();
        int half;
        if (fileLength % 2 == 0)
            half = fileLength / 2;
        else half = (fileLength / 2) + 1;

        byte[] buffer = new byte[half];
        fileReader.read(buffer);
        outputStream1.write(buffer);
        buffer = new byte[fileLength - half];
        fileReader.read(buffer);
        outputStream2.write(buffer);

        bufferedReader.close();
        fileReader.close();
        outputStream1.close();
        outputStream2.close();
    }
}