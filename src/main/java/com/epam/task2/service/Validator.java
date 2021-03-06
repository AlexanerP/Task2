package com.epam.task2.service;

/**
 * @author Alexander Pishchala
 *
 * In this class, I check that the values​are valid and that their length does not exceed the specified values.
 */
public class Validator {

    private static final int MAX_TEXT_VALUE = 100;
    private static final int MIN_TEXT_VALUE = 1;
    private static final String REGEX_NUMBER = "^[0-9]*[.,]?[0-9]+$";

    public static boolean validatorText(String text) throws ServiceException{
        if(!(text.length() < MAX_TEXT_VALUE) && !(text.length() > MIN_TEXT_VALUE)) {
            throw new ServiceException("Invalid value - " + text);
        }
        return true;
    }

    public static boolean isNumber(String text) {
        if(text.trim().matches(REGEX_NUMBER)) {
            return true;
        }
        return false;
    }
}
