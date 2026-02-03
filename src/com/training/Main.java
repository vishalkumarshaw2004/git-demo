package com.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:postgresql://localhost:5432/training";
        String username = "postgres";
        String password = "1234";

        System.out.println("hello");

        Class.forName("org.postgresql.Driver"); // important

        Connection c = DriverManager.getConnection(url, username, password);

        if (c != null) {
            System.out.println("Connected Successfully");
        } else {
            System.out.println("Connection failed");
        }
        Statement s =c.createStatement();
        String q = "Select * from employee";
        s.executeQuery(q);
        ResultSet r = s.getResultSet();
        while(r.next()) {
        	System.out.println(r.getString("emp_id"));
        	System.out.println(r.getString("emp_name"));
        }
    }
}
