package com.pluralsight.calcengine.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserLogicTest {

    @Test
    void addUser() {
        Assertions.assertEquals(1,
                new BooksLogic.add("us1", "hendry", "hendry@gmail.com", "2-3-2004"));

    }

    @Test
    void searchUser() {
        Assertions.assertEquals(1, new BooksLogic.search("us1"));
    }

    @Test
    void delete() {
        Assertions.assertEquals(1,new BooksLogic.delete("us1"));
    }

    @Test
    void view() {

    }
}