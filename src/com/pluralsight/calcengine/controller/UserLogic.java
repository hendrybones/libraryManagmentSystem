package com.pluralsight.calcengine.controller;

import com.pluralsight.calcengine.models.Users;
import com.pluralsight.calcengine.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserLogic  {
//    String UserId, String name, String email, String date
    public static int add(Users users) {
        int status = 0;
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into Users(UserId,name,email,regDate) values(?,?,?,?)");
            ps.setString(1, users.getUserId());
            ps.setString(2, users.getName());
            ps.setString(3, users.getEmail());
            ps.setString(4, users.getRegDate());
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

  public static int delete(Users users) {
        int status = 0;
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement ps=con.prepareStatement("DELETE FROM users where userId=?");
            ps.setString(1, users.getUserId());
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
    public static boolean validate(String name,String password){
        boolean status=false;
        try{
            Connection con=DbUtil.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from Users where UserName=? and UserPass=?");
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
    public static boolean CheckIfAlready(String UserName)
    {
        boolean status=false;
        try{
            Connection con=DbUtil.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from Users where UserName=?");
            ps.setString(1,UserName);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;

    }


}
