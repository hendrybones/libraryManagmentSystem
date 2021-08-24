package com.pluralsight.calcengine;

import com.pluralsight.calcengine.controller.BooksLogic;
import com.pluralsight.calcengine.controller.UserLogic;
import com.pluralsight.calcengine.models.Books;
import com.pluralsight.calcengine.models.Users;
import com.pluralsight.calcengine.util.DbUtil;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException, SQLException {
        DbUtil db=new DbUtil();
        UserLogic user=new UserLogic();
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
                getBookDetails();
                break;
            case 2:
               BooksLogic.view();
                break;
            case 3:
//                BooksLogic.updateBook();

                break;
            case 4:
                BooksLogic.delete("");

                break;
            case 5:
                 BooksLogic.search("");
                break;
            case 6:
                getUserDetails();
                break;
            case 7:
                UserLogic.search("");
                break;
            case 8:
                UserLogic.delete("");
            default:
                System.out.println("select the correct option");
        }
        while (choice!=0);


    }
    public static void getBookDetails(){
        BooksLogic log=new BooksLogic();
        Scanner scan=new Scanner(System.in);
        System.out.println("enter bookId");
        String bookId=scan.nextLine();
        System.out.println("enter book name");
        String bookName=scan.nextLine();
        System.out.println("enter author");
        String author=scan.nextLine();
        System.out.println("enter publisher");
        String publisher=scan.nextLine();
        System.out.println("enter quantity");
        int quantity=scan.nextInt();
        Books b=new Books(bookId,bookName,author,publisher,quantity);
        log.add(bookId,bookName,author,publisher,quantity);


    }
    public static void getUserDetails() throws ParseException {
        UserLogic user=new UserLogic();
        Scanner scan=new Scanner(System.in);
        System.out.println("enter userId");
        String userId=scan.nextLine();
        System.out.println("enter user name");
        String name=scan.nextLine();
        System.out.println("enter user email");
        String email=scan.nextLine();
        System.out.println("enter date of registration (dd-MM-yyyy)");
        String date = scan.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateOfBirth = simpleDateFormat.parse(date);
        Users u=new Users(userId,name,email,date);
        user.add(userId,name,email,date);

    }


}
