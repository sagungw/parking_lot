package com.agung.parking_lot.command;

import com.agung.parking_lot.ApplicationContext;

public interface Command {

    String toString();

    void execute(ApplicationContext applicationContext, String... args);

}
