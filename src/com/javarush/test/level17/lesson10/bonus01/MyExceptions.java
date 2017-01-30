package com.javarush.test.level17.lesson10.bonus01;

class MyExceptions
{
    static class NoSuchTypeOfCrUDException extends Exception
    {
        @Override
        public String toString()
        {
            return this.getClass().getSimpleName() + " Error type added, try '-c', '-u', '-d', '-i' with parameters!";
        }
    }

    static class NoSuchSexTypeException extends Exception
    {
        @Override
        public String toString()
        {
            return this.getClass().getSimpleName() + " Error type added, try 'м' or 'ж' !";
        }
    }

}