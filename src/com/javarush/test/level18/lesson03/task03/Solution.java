package com.javarush.test.level18.lesson03.task03;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bufferedReader.readLine();
        File fileSource = new File(filePath);
        if (!fileSource.exists() && !fileSource.canRead()) return;

        InputStream inputStream = new FileInputStream(fileSource);
        Integer tempKey;
        Integer tempValue;
        HashMap<Integer, Integer> keyCounterMap = new HashMap<>();

        while (inputStream.available() > 0) {
            tempKey = inputStream.read();
            if (keyCounterMap.containsKey(tempKey)) {
                tempValue = keyCounterMap.get(tempKey);
                keyCounterMap.put(tempKey, ++tempValue);
            } else
                keyCounterMap.put(tempKey, 1);
        }

        tempValue = Integer.MIN_VALUE;
        for (Map.Entry entry : keyCounterMap.entrySet()) {
            if ((Integer) entry.getValue() >= tempValue)
                tempValue = (Integer) entry.getValue();
        }


        for (Map.Entry maxValues : keyCounterMap.entrySet())
            if (maxValues.getValue().equals(tempValue))
                System.out.println(maxValues.getKey());

        bufferedReader.close();
        inputStream.close();
    }
}
