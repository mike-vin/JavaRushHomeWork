package com.javarush.test.level18.lesson03.task04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bufferedReader.readLine();


        File file = new File(filePath);
        if (!file.exists() && !file.canRead()) return;

        InputStream inStreamReader = new FileInputStream(file);
        Map<Integer, Integer> allData = new HashMap<>();
        int tempKey = 0, tempValue, minValue = Integer.MAX_VALUE;

        while (inStreamReader.available() > 0) {
            tempKey = inStreamReader.read();
            if (allData.containsKey(tempKey)) {
                tempValue = allData.get(tempKey);
                allData.put(tempKey, ++tempValue);
            } else allData.put(tempKey, 1);
        }
        String result = "";
        for (Map.Entry inMap : allData.entrySet())
            if ((int) inMap.getValue() < minValue) minValue = (int) inMap.getValue();

        for (Map.Entry inMap : allData.entrySet())
            if (inMap.getValue().equals(minValue)) {
                result = result + inMap.getKey() + " ";
                System.out.println(result.trim());
            }

        bufferedReader.close();
        inStreamReader.close();
    }
}
