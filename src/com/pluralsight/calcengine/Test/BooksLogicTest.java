package com.pluralsight.calcengine.Test;

import com.pluralsight.calcengine.controller.BooksLogic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooksLogicTest {


    @Test
    void add() {
        Assertions.assertEquals(1,
               new BooksLogic().add("bef6", "rich dad", "charles", "jesma publisher", 1));
    }

    @Test
    void search() {
        Assertions.assertEquals("bef1 ,chalk, hendry, jesma publisher", "2-3-2004",new BooksLogic().search("bef1"));

    }

    @Test
    void view() {

    }

    @Test
    void delete() {
        Assertions.assertEquals(1,new BooksLogic().delete("bef5"));

    }

    @Test
    void updateBook() {
    }

}