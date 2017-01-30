package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки.

Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
/*          
        String file1 = "C:\\Users\\Mike\\Desktop\\1.txt";
        String file2 = "C:\\Users\\Mike\\Desktop\\2.txt";
*/
        br.close();

        String finalString = getFormattedString(file1);
        writeBuffer(file2, finalString);
    }

    private static String getFormattedString(String fileFrom) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder finalString = new StringBuilder();
        FileInputStream input = new FileInputStream(fileFrom);
        int data;
        char symbol;
        while ((data = input.read()) > -1) {
            symbol = (char) data;
            // System.out.print(symbol);
            if (symbol != ' ') stringBuilder.append(symbol);
            else {
                double aDouble = Double.valueOf(stringBuilder.toString());
                finalString.append((int) Math.round(aDouble));
                finalString.append(" ");
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        if (stringBuilder.length() > 0)
            finalString.append((int) Math.round(Double.valueOf(stringBuilder.toString())));
        input.close();
        return finalString.toString();
    }

    private static void writeBuffer(String fileDestination, String finalString) throws IOException {
        FileOutputStream output = new FileOutputStream(fileDestination);
        output.write(finalString.getBytes());
        output.close();
    }
}