package com.javarush.test.level18.lesson10.home04;

/*  Объединение файлов
 читать с консоли 2 имени файла
   В начало первого файла записать содержимое второго файла так,
   чтобы получилось объединение файлов
   Закрыть потоки.!!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();

        br.close();

        byte[] bufferFromFirstFile = getBuffer(file1);
        byte[] bufferFromSecondFile = getBuffer(file2);
        writeBuffer(file1, bufferFromSecondFile, false);
        writeBuffer(file1, bufferFromFirstFile, true);
    }

    private static void writeBuffer(String fileDestination, byte[] buffer, boolean append) throws IOException {
        FileOutputStream output = new FileOutputStream(fileDestination, append);
        output.write(buffer);
        output.close();
    }

    private static byte[] getBuffer(String fileFrom) throws IOException {
        FileInputStream input = new FileInputStream(fileFrom);
        byte[] buffer = new byte[input.available()];
        input.read(buffer);
        input.close();
        //System.out.println("<getBuffer>\n\t -> buffer.length = " + buffer.length + "\nfile From ->" + fileFrom);
        return buffer;
    }
}