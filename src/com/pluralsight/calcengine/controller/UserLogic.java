package com.pluralsight.calcengine.controller;

import com.pluralsight.calcengine.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserLogic {
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
    public static boolean search(String UserName)
    {
        boolean status=false;
        try{
            Connection con=DbUtil.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from Users where name=?");
            ps.setString(1,UserName);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;

    }
    public static int delete() {
        int status = 0;
        try {
            Connection con = DbUtil.getConnection();
            Scanner scanner=new Scanner(System.in);
            System.out.println("enter userId to delete");
            String userId = scanner.nextLine();
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
    public  static void view(){

    }

}
