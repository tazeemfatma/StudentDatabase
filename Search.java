package com.example.user.databasestud;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.databasestud.dbutil.StudentConstant;
import com.example.user.databasestud.dbutil.StudentManager;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    EditText roll;
    //TextView rollno,nm,course,email,phone;
    StudentManager studentManager;
    SQLiteDatabase sqLiteDatabase;
    ArrayList<Studentbean> stud;
    Studentbean st;
    ListView detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        roll=findViewById(R.id.roll);
        detail=findViewById(R.id.detail);
       /* rollno=findViewById(R.id.rollno);
        nm=findViewById(R.id.nm);
        course=findViewById(R.id.course);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);*/
        studentManager=new StudentManager(this);
        sqLiteDatabase=studentManager.openDB();
        stud=new ArrayList<>();
    }

    public void Searchitem(View view) {
        String id=roll.getText().toString().trim();
        String[]args={id};
       // Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
        String[]colnames={StudentConstant.COL_NAME,StudentConstant.COL_COURSE,StudentConstant.COL_EMAIL,StudentConstant.COL_PHONE};

        //Cursor cursor=sqLiteDatabase.query(StudentConstant.TABLE_NAME,null,StudentConstant.COL_ID+" =? and "+StudentConstant.COL_EMAIL+"=?",args,null,null,null);
        Cursor cursor=sqLiteDatabase.query(StudentConstant.TABLE_NAME,colnames,StudentConstant.COL_ID+" =?",args,null,null,null);
        if(cursor!=null && cursor.moveToFirst()) {
           // String r=cursor.getString(cursor.getColumnIndex(StudentConstant.COL_ID));
            String name=cursor.getString((cursor.getColumnIndex(StudentConstant.COL_NAME)));
            String c=cursor.getString(cursor.getColumnIndex(StudentConstant.COL_COURSE));
            String e=cursor.getString(cursor.getColumnIndex(StudentConstant.COL_EMAIL));
            String p=cursor.getString(cursor.getColumnIndex(StudentConstant.COL_PHONE));
            st=new Studentbean(name,c,e,p);
            stud.add(st);
           // rollno.setText(r);
           /* nm.setText(name);
            course.setText(c);
            email.setText(e);
            phone.setText(p);*/
            ArrayAdapter<Studentbean> ad=new ArrayAdapter<Studentbean>(this,android.R.layout.simple_list_item_1,stud);
            detail.setAdapter(ad);
        }
        else{
            Toast.makeText(this, "no such roll no exist", Toast.LENGTH_SHORT).show();
        }

cursor.close();
    }
}
