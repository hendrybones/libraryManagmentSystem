package com.pluralsight.calcengine.controller;

import com.mysql.jdbc.Statement;
import com.pluralsight.calcengine.models.Books;
import com.pluralsight.calcengine.util.DbUtil;
import com.pluralsight.calcengine.util.LogInterface;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BooksLogic {
//    String bookId, String name, String author, String publisher, int quantity

    public static int add(Books books) {
        int status = 0;
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into book(bookId,bookName,author,publisher,quantinty) values(?,?,?,?,?)");
            ps.setString(1, books.getCallNo());
            ps.setString(2, books.getName());
            ps.setString(3, books.getAuthor());
            ps.setString(4, books.getPublisher());
            ps.setInt(5, books.getQuantity());
            status = ps.executeUpdate();
            System.out.println("book inserted successfully");
            con.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;

    }

    public static String search(String bookId) {
        String a ="";
        try (Connection con = DbUtil.getConnection()) {
            String sql = "select*from book where bookId=?;";
            PreparedStatement stmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, bookId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("there is no such record in the database");
            } else {
                rs.previous();
                while (rs.next()) {
                    a = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "+
                            rs.getString(4) + " " + rs.getString(5);
                    System.out.println(a);
                }
            }
           DbUtil.closeConnections();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return a;

    }
    public  static void view() throws SQLException {
        try {
            Connection con = DbUtil.getConnection();
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from book");
            while(rs.next()){
                String c=rs.getString(1) +" "+ rs.getString(2)+" " +rs.getString(3);
                System.out.println(c);
            }
        }catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }
    public  static int delete(String bookId){
        int status= 0;
        try(Connection con = DbUtil.getConnection()) {
            PreparedStatement ps=con.prepareStatement("DELETE FROM Book where bookId=?");
            ps.setString(1, bookId);
            status=ps.executeUpdate();
            if (status > 0) {
                System.out.println("deleted the record from the database");
            } else {
                System.out.println("no such record in the database");
            }
        }catch(Exception e){System.out.println(e);}
        return status;

    }
    public static int updateBook(String bookId) {
        int status = 0;
        int quantity = 0, issued = 0;
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("select quantity,issued from book where bookId=?");
            ps.setString(1, bookId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt("quantity");
                issued = rs.getInt("issued");
            }
            if (quantity > 0) {
                PreparedStatement ps2 = con.prepareStatement("update book set quantity=?,issued=? where bookId=?");
                ps2.setInt(1, quantity - 1);
                ps2.setInt(2, issued + 1);
                ps2.setString(3, bookId);

                status = ps2.executeUpdate();
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}