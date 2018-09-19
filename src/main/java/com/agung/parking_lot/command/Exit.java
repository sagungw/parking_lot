package com.agung.parking_lot.command;

import com.agung.parking_lot.ApplicationContext;

public class Exit implements Command {

    @Override
    public String toString() {
        return "exit";
    }

    @Override
    public void execute(ApplicationContext applicationContext, String... args) {
        applicationContext.appRun = false;
    }
}
