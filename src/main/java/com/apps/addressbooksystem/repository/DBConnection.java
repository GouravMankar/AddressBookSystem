package com.apps.addressbooksystem.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/AddressBookDB";
    private static final String USER = "root";
    private static final String PASSWORD = "2580";

    public static Connection getConnection() throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}