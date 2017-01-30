package com.javarush.test.level17.lesson10.bonus01;


class PersonFieldsParser
{
    private StringCleaner cleaner;
    private String name;
    private String sex;
    private String dateOfBirthday;
    private int id;
    private boolean hasID;

    public String getName()
    {
        return name;
    }

    public String getSex()
    {
        return sex;
    }

    public String getDateOfBirthday()
    {
        return dateOfBirthday;
    }

    public int getId()
    {
        return id;
    }

    public PersonFieldsParser(String inputString, boolean hasId)
    {
        this.cleaner = new StringCleaner();
        this.hasID = hasId;
        parseFields(inputString);
    }

    private void parseFields(String inputStr)
    {
        String shortCut = cleaner.cleanSpacesFromString(inputStr);
// without "-u":
        shortCut = shortCut.substring(3, shortCut.length());
        if (hasID)
        {
            shortCut = shortCut.replaceFirst(" ", ".");
           // print(shortCut);
            String idString = shortCut.substring(0, shortCut.indexOf("."));
           // print(idString);

            id = Integer.parseInt(idString);
            shortCut = shortCut.substring(shortCut.indexOf(".") + 1, shortCut.length());
        }
        dateOfBirthday = shortCut.substring(shortCut.lastIndexOf(" ") + 1, shortCut.length());
    //    print(dateOfBirthday);

// without date Of Birthday:
        shortCut = shortCut.substring(0, shortCut.length() - dateOfBirthday.length());
        sex = shortCut.substring(shortCut.length() - 2, shortCut.length() - 1).toLowerCase();
      //  print(sex);

// without sex:
        shortCut = shortCut.substring(0, shortCut.length() - 2);
        name = shortCut;
// cut list spaces:
        name = cleaner.cleanSpacesFromString(name);
     //   print(name);

    }

 private void print(String inf)
    {
        System.out.println("(" + inf + ")");
    }

}
