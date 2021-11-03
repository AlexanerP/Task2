package com.epam.task2.dao.impl;

import com.epam.task2.dao.Write;

public class WriteToConsoleImpl implements Write {
    @Override
    public void write(Object object) {
        System.out.println(object);
    }
}
