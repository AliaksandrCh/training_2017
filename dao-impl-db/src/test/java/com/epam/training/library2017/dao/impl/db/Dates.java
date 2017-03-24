package com.epam.training.library2017.dao.impl.db;

public class Dates {

    public static void main(String[] args) {
        java.util.Date date = new java.util.Date();
        System.out.println(date);

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);

        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(date.getTime());
        System.out.println(sqlTimestamp);
    }

}
