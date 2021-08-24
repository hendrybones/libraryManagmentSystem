package com.pluralsight.calcengine.controller;

import com.pluralsight.calcengine.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LibraryManagementLogic {
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
