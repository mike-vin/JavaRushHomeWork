package com.javarush.test.level17.lesson10.bonus01;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.javarush.test.level17.lesson10.bonus01.RequestType.*;

class CrudImpl implements CrUDI
{
    private static final boolean CREATE_FLAG = false, UPDATE_FLAG = true;
    private List<Person> people;
    private StringCleaner cleaner;

    String getStringFromConsole() throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }


    @Override
    public void execute(String inputString, List<Person> allPeople)
            throws MyExceptions.NoSuchTypeOfCrUDException, ParseException, MyExceptions.NoSuchSexTypeException
    {
        this.cleaner = new StringCleaner();
        this.people = allPeople;
// getTYPE:
        RequestType requestType = getType(inputString);
        switch (requestType)
        {
            case CREATE:
                allPeople.add(createNewPerson(inputString));
                System.out.printf("%s%d", "Adding successful. ID: ", allPeople.size() - 1);
                break;

            case UPDATE:
                updateExistingPerson(inputString);
                break;

            case DELETE:
                deletePerson(inputString);
                break;

            case INFO:
                getInfoPerson(inputString);
                break;

            default:
                throw new MyExceptions.NoSuchTypeOfCrUDException();
        }
    }

    private RequestType getType(String requestString) throws MyExceptions.NoSuchTypeOfCrUDException
    {
        if (requestString.toLowerCase().contains("-c")) return CREATE;
        else if (requestString.toLowerCase().contains("-u")) return UPDATE;
        else if (requestString.toLowerCase().contains("-d")) return DELETE;
        else if (requestString.toLowerCase().contains("-i")) return INFO;
        else throw new MyExceptions.NoSuchTypeOfCrUDException();
    }

    //==================================================================================================================
//======================================================================================================================
    @Override
    public Person createNewPerson(String createString)
            throws ParseException, MyExceptions.NoSuchSexTypeException
    {
        System.out.println("Adding new Person:");

// INITIAL fields:
        PersonFieldsParser fieldsParser = new PersonFieldsParser(createString, CREATE_FLAG);
        String name = fieldsParser.getName();
        String sex = fieldsParser.getSex();
        String dateOfBirthday = fieldsParser.getDateOfBirthday();

        Date dayOfBirthdayDate = formatStringToDate(dateOfBirthday);
// CREATE PERSON:
        if (isMale(sex))
            return Person.createMale(name, dayOfBirthdayDate);
        else
            return Person.createFemale(name, dayOfBirthdayDate);
    }

    private boolean isMale(String sex) throws MyExceptions.NoSuchSexTypeException
    {
        if (sex.toLowerCase().contains("м".toLowerCase())) return true;
        else if (sex.toLowerCase().contains("ж".toLowerCase())) return false;
        else throw new MyExceptions.NoSuchSexTypeException();
    }

    private Date formatStringToDate(String dateOfBirthday) throws ParseException
    {
        SimpleDateFormat simpleDateFormatParser = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormatParser.parse(dateOfBirthday);
    }

    private String formatDateToString(Date dateOfBirthday) throws ParseException
    {
        SimpleDateFormat simpleDateFormatWriter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return simpleDateFormatWriter.format(dateOfBirthday);
    }


    //==================================================================================================================
//======================================================================================================================
    @Override
    public void updateExistingPerson(String updateString) throws ParseException, MyExceptions.NoSuchSexTypeException
    {
        PersonFieldsParser fieldsParser = new PersonFieldsParser(updateString, UPDATE_FLAG);
// INITIAL fields:
        final int ID = fieldsParser.getId();
        String newName = fieldsParser.getName();
        Sex newSex = isMale(fieldsParser.getSex()) ? Sex.MALE : Sex.FEMALE;
        String newDateOfBirthday = fieldsParser.getDateOfBirthday();
        Date correctFormatDayOfBirthday = formatStringToDate(newDateOfBirthday);

        Person personForUpdate = people.get(ID);
        System.out.printf("Old person fields: %s  %s  %s", personForUpdate.getName(), personForUpdate.getSex(), formatDateToString(personForUpdate.getBirthDay()));

// SET NEW fields:
        personForUpdate.setName(newName);
        personForUpdate.setSex(newSex);
        personForUpdate.setBirthDay(correctFormatDayOfBirthday);
// print:
        System.out.printf("\nRewritten to:\t ");
        getInfoPerson("-i " + ID);
    }


    //==================================================================================================================
//======================================================================================================================
    @Override
    public void deletePerson(String inputString)
    {
        int id = getIdForDeleteOrInfo(inputString);
        System.out.printf("Person %s with ID %d removed.", people.get(id).getName(), id);
        people.remove(id);
    }


    //==================================================================================================================
//======================================================================================================================
    @Override
    public void getInfoPerson(String inputString) throws ParseException
    {
        int ID = getIdForDeleteOrInfo(inputString);
        Person personForInfo = people.get(ID);

        String sex = personForInfo.getSex() == Sex.MALE ? "м" : "ж";
        String cleanString = personForInfo.getName() + " " + sex + " " + formatDateToString(personForInfo.getBirthDay());
        System.out.println(cleanString);
    }

    private int getIdForDeleteOrInfo(String inputString)
    {
        String IdString = cleaner.cleanSpacesFromString(inputString);
        IdString = cleaner.cleanSpacesFromString(IdString.substring(2, IdString.length()));  // without "-'Symbol'":
        return Integer.parseInt(IdString);
    }
}
