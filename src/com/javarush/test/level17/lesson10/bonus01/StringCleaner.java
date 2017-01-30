package com.javarush.test.level17.lesson10.bonus01;

class StringCleaner
{
    String cleanSpacesFromString(String currentString)
    {
        if (' ' == currentString.charAt(0)) currentString = removeFirstSpace(currentString);
        if (' ' == currentString.charAt(currentString.length() - 1)) currentString = removeLastSpace(currentString);
        if (currentString.contains("  ")) currentString = removeInnerSpacesExceptOne(currentString);
        return currentString;
    }

    private String removeInnerSpacesExceptOne(String currentString)
    {
        currentString = currentString.replace("  ", " ");
        if (currentString.contains("  ")) currentString = removeInnerSpacesExceptOne(currentString);
        return currentString;
    }

    private String removeFirstSpace(String dirtyString)
    {
        String cleanStringFirstSpace = dirtyString.substring(1, dirtyString.length());
        if (' ' == cleanStringFirstSpace.charAt(0))
            cleanStringFirstSpace = removeFirstSpace(cleanStringFirstSpace);
        return cleanStringFirstSpace;
    }

    private String removeLastSpace(String dirtyString)
    {
        String cleanStringLastSpace = dirtyString.substring(0, dirtyString.length() - 1);
        if (' ' == cleanStringLastSpace.charAt(cleanStringLastSpace.length() - 1))
            cleanStringLastSpace = removeLastSpace(cleanStringLastSpace);
        return cleanStringLastSpace;
    }
}
