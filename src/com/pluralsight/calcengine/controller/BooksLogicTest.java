package com.pluralsight.calcengine.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooksLogicTest {

    @Test
    void add() {
        Assertions.assertEquals(1,
               new BooksLogic.add("bef1", "chalk", "hendry", "jesma publisher", "2-3-2004"));
    }

    @Test
    void search() {
        Assertions.assertEquals("bef1", "chalk", "hendry", "jesma publisher", "2-3-2004",new BooksLogic.search("bef1"));

    }

    @Test
    void view() {

    }

    @Test
    void delete() {
        Assertions.assertEquals(1,new BooksLogic.delete("bef2"));

    }

    @Test
    void updateBook() {
    }
}