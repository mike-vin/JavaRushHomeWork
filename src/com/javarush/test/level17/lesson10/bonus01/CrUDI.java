package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.util.List;

public interface CrUDI
{

    void execute(String inputString, List<Person> allPeople)
            throws MyExceptions.NoSuchTypeOfCrUDException, ParseException, MyExceptions.NoSuchSexTypeException;

    Person createNewPerson(String newPerson)
            throws ParseException, MyExceptions.NoSuchTypeOfCrUDException, MyExceptions.NoSuchSexTypeException;

    void updateExistingPerson(String inputString) throws ParseException, MyExceptions.NoSuchSexTypeException;

    void deletePerson(String inputString);

    void getInfoPerson(String inputString) throws ParseException;

}
