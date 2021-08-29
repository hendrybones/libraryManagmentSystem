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
        Books books=new Books();
//        BooksLogic log=new BooksLogic();
        Scanner scan=new Scanner(System.in);
        System.out.println("enter bookId");
        String bookId=scan.nextLine();
        books.setCallNo(bookId);

        System.out.println("enter book name");
        String bookName=scan.nextLine();
        books.setName(bookName);

        System.out.println("enter author");
        String author=scan.nextLine();
        books.setAuthor(author);

        System.out.println("enter publisher");
        String publisher=scan.nextLine();
        books.setPublisher(publisher);

        System.out.println("enter quantity");
        int quantity=scan.nextInt();
        books.setQuantity(quantity);
//        Books b=new Books(bookId,bookName,author,publisher,quantity);
//        log.add(bookId,bookName,author,publisher,quantity);
    }
    public static void userRegistration() throws ParseException {
        Users users=new Users();
//        UserLogic user=new UserLogic();
        Scanner scan=new Scanner(System.in);
        System.out.println("enter userId");
        String userId=scan.nextLine();
        users.setUserId(userId);

        System.out.println("enter user name");
        String name=scan.nextLine();
        users.setName(name);

        System.out.println("enter user email");
        String email=scan.nextLine();
        users.setEmail(email);

        System.out.println("enter date of registration (dd-MM-yyyy)");
        String date = scan.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateOfBirth = simpleDateFormat.parse(date);
        users.setRegDate(date);
//        Users u=new Users(userId,name,email,date);
//        user.add(userId,name,email,date);
    }
    public static void getUserList(){

    }
    public static void getUserToDelete(){
        Users users=new Users();
//        UserLogic logic=new UserLogic();
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter userId to delete");
        String userId = scanner.nextLine();
        users.setUserId(userId);
//        logic.delete(userId);

    }
    public static void getUserToSearch(){
//       ? UserLogic logic=new UserLogic();
       Users users=new Users();
        System.out.println("enter UserId");
        Scanner input = new Scanner(System.in);
        String UserId = input.nextLine();
        users.setUserId(UserId);
//        logic.search(UserId);

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
    public static void userLogin(){
        UserLogic logic=new UserLogic();
        System.out.println("enter userName");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("enter password");
        String password=input.nextLine();
        logic.validate(name,password);
    }


}
