package com.epam.task2.dao.impl;

import com.epam.task2.dao.Write;

/**
 * @author Alexander Pishchala
 *
 * This is a class for writing information to the console. It inherits the 'Write' interface
 * and describes a method where to write
 */
public class WriteToConsoleImpl implements Write {
    @Override
    public void write(Object object) {
        System.out.println(object);
    }
}
