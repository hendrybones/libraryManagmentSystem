package com.pluralsight.calcengine.controller;

import com.pluralsight.calcengine.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BooksLogic {
    public static int add(String bookId, String name, String author, String publisher, int quantity) {
        int status = 0;
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into book(bookId,bookName,author,publisher,quantity) values(?,?,?,?,?)");
            ps.setString(1, bookId);
            ps.setString(2, name);
            ps.setString(3, author);
            ps.setString(4, publisher);
            ps.setInt(5, quantity);
            status = ps.executeUpdate();
            con.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;

    }

    public static boolean search(String bookId) {
        boolean status = false;
        try (Connection con = DbUtil.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from Book where bookId = ?");
            ps.setString(1, bookId);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
//    public  static int view(){
//
//    }
    public  static int delete(){
        int status= 0;
        try(Connection con = DbUtil.getConnection()) {
            Scanner scanner=new Scanner(System.in);
            System.out.println("enter bookId to delete");
            String bookId = scanner.nextLine();
            PreparedStatement ps=con.prepareStatement("DELETE FROM Book where bookId=?");
            ps.setString(1, bookId);
            status=ps.executeUpdate();
            ps.
        }catch(Exception e){System.out.println(e);}
        return status;

    }

    public static int updateBook(String bookCallNo) {
        int status = 0;
        int quantity = 0, issued = 0;
        try {
            Connection con = DbUtil.getConnection();

            PreparedStatement ps = con.prepareStatement("select quantity,issued from book where callno=?");
            ps.setString(1, bookCallNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt("quantity");
                issued = rs.getInt("issued");
            }

            if (quantity > 0) {
                PreparedStatement ps2 = con.prepareStatement("update book set quantity=?,issued=? where callno=?");
                ps2.setInt(1, quantity - 1);
                ps2.setInt(2, issued + 1);
                ps2.setString(3, bookCallNo);

                status = ps2.executeUpdate();
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

}