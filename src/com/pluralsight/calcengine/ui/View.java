package com.pluralsight.calcengine.ui;

import com.pluralsight.calcengine.controller.BooksLogic;
import com.pluralsight.calcengine.controller.UserLogic;
import com.pluralsight.calcengine.models.Books;
import com.pluralsight.calcengine.models.Users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class View {
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
    public static void getUserList(){

    }
    public static void getUserToDelete(){
        UserLogic logic=new UserLogic();
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter userId to delete");
        String userId = scanner.nextLine();
        logic.delete(userId);

    }
    public static void getUserToSearch(){
        UserLogic logic=new UserLogic();
        System.out.println("enter UserId");
        Scanner input = new Scanner(System.in);
        String UserId = input.nextLine();
        logic.search(UserId);

    }
    public static void getBookList(){

    }
    public static void getBookUpdate(){
        BooksLogic logic=new BooksLogic();
        Scanner scan =new Scanner(System.in);
        System.out.println("enter the bookId to update");
        String bookId = scan.nextLine();
        logic.updateBook(bookId);

    }
    public static void getBookToDelete(){
        BooksLogic logic=new BooksLogic();
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter bookId to delete");
        String bookId = scanner.nextLine();
        logic.delete(bookId);


    }
    public static void getBookIssuing(){

    }
    public static void getBookReturned(){

    }
    public static void getBookSearch(){
        BooksLogic logic=new BooksLogic();
        System.out.println("enter bookId");
        Scanner input = new Scanner(System.in);
        String bookId = input.nextLine();
        logic.search(bookId);



    }

}
