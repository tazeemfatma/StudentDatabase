package com.example.user.databasestud.dbutil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 2/15/2018.
 */

public class StudentManager {
    StudentHelper studentHelper;
    SQLiteDatabase sqLiteDatabase;
    public StudentManager(Context context){
        studentHelper=new StudentHelper(context,StudentConstant.DBNAME,null,StudentConstant.DBVERSION);

    }
public SQLiteDatabase openDB(){
       sqLiteDatabase=studentHelper.getWritableDatabase();
       return sqLiteDatabase;

}
//public void closeDB(){StudentHelper.close();}

}
