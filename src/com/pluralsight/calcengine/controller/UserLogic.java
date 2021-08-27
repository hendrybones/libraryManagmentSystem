package com.pluralsight.calcengine.controller;

import com.pluralsight.calcengine.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserLogic  {

    public static int add(String UserId, String name, String email, String date) {
        int status = 0;
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into Users(UserId,name,email,regDate) values(?,?,?,?)");
            ps.setString(1, UserId);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, date);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
public static String search(String UserId)
    {
        String a ="";
        try (Connection con = DbUtil.getConnection()) {
//            System.out.println("enter UserId");
//            Scanner input = new Scanner(System.in);
//            UserId = input.nextLine();
            String sql = "select*from book where UserId=?;";
            PreparedStatement stmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, UserId);
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

  public static int delete(String userId) {
        int status = 0;
        try {
            Connection con = DbUtil.getConnection();
//            Scanner scanner=new Scanner(System.in);
//            System.out.println("enter userId to delete");
//            userId = scanner.nextLine();
            PreparedStatement ps=con.prepareStatement("DELETE FROM users where userId=?");
            ps.setString(1, userId);
            status=ps.executeUpdate();
            if (status > 0) {
                System.out.println("deleted the user from the database");
            } else {
                System.out.println("user does not exist");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
