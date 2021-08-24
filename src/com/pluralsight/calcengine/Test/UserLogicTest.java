package com.pluralsight.calcengine.Test;

import com.pluralsight.calcengine.controller.BooksLogic;
import com.pluralsight.calcengine.controller.UserLogic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserLogicTest {


    @Test
    void addUser() {
        Assertions.assertEquals(1,
                new UserLogic().add("us1", "hendry", "hendry@gmail.com", "2-3-2004"));

    }

    @Test
    void searchUser() {
        Assertions.assertEquals(1, new UserLogic().search("us1"));
    }

    @Test
    void delete() {
        Assertions.assertEquals(1,new UserLogic().delete("us1"));
    }


    @Test
    void view() {

    }
}