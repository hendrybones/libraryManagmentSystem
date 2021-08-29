package com.pluralsight.calcengine;

import com.pluralsight.calcengine.controller.BooksLogic;
import com.pluralsight.calcengine.controller.UserLogic;
import com.pluralsight.calcengine.models.Books;
import com.pluralsight.calcengine.models.Users;
import com.pluralsight.calcengine.ui.View;
import com.pluralsight.calcengine.util.DbUtil;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException, SQLException {
        int select=0;

        System.out.println("***************user authentication *************************");
        System.out.println("****************select 1 for login and 2 to register*************");
        System.out.println("\n1. login\n" +
                "\n2. registration \n");
        Scanner scanner=new Scanner(System.in);
        select=scanner.nextInt();
        switch (select){
            case  1:
                View.userLogin();
                break;
            case 2:
                View.userRegistration();
        }

        int choice=0;
        System.out.println("************Library management system*************************");
        System.out.println("\n1. Add books\n" +
                "2. view available books\n" +
                "3. update book\n" +
                "4. delete book\n" +
                "5.search book \n" +
                "6. add users \n" +
                "7.view users \n" +
                "8. delete user\n" +
                "0. Exit\n");
        Scanner scan=new Scanner(System.in);
        choice=scan.nextInt();
        switch (choice){
            case 1:
                View.getBookDetails();
                break;
            case 2:
               BooksLogic.view();
                break;
            case 3:
                View.getBookUpdate();

                break;
            case 4:
                View.getBookToDelete();

                break;
            case 5:
                 View.getBookSearch();
                break;
            case 6:
//              ??  View.getUserDetails();
                break;
            case 7:
                View.getUserToSearch();
                break;
            case 8:
                View.getUserToDelete();
            default:
                System.out.println("select the correct option");
        }
        while (choice!=0);


    }




}
