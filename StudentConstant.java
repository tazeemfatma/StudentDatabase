package com.example.user.databasestud.dbutil;

/**
 * Created by user on 2/15/2018.
 */

public class StudentConstant {
    public static final String DBNAME="College";
    public static final int DBVERSION=1;
    public static final String TABLE_NAME="student";
    public static final String COL_ID="studroll";
    public static final String COL_NAME="studname";
    public static final String COL_COURSE="studcourse";
    public static final String COL_EMAIL="studemail";
    public static final String COL_PHONE="phone";
    public static final String STUD_SQL="create table student(studroll integer primary key,studname text, studcourse text,studemail text,phone text)";


}

