package com.example.user.databasestud;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.user.databasestud.dbutil.StudentConstant;
import com.example.user.databasestud.dbutil.StudentManager;

public class Student extends AppCompatActivity {
    EditText roll;
    EditText name;
    Spinner course;
    EditText email;
    EditText phone;
    StudentManager studentManager;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        roll=findViewById(R.id.roll);
        name=findViewById(R.id.name);
        course=findViewById(R.id.course);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        studentManager=new StudentManager(this);
        sqLiteDatabase=studentManager.openDB();

    }

    public void submit(View view) {
        String r=roll.getText().toString().trim();
        String n=name.getText().toString().trim();
        String c=(String) course.getSelectedItem();
        String e=email.getText().toString();
        String p=phone.getText().toString();
        ContentValues contentValues=new ContentValues();
        contentValues.put(StudentConstant.COL_ID,r);
        contentValues.put(StudentConstant.COL_NAME,n);
        contentValues.put(StudentConstant.COL_COURSE,c);
        contentValues.put(StudentConstant.COL_EMAIL,e);
        contentValues.put(StudentConstant.COL_PHONE,p);
        long l=sqLiteDatabase.insert(StudentConstant.TABLE_NAME,null,contentValues);
        if(l>0)
        {
            Toast.makeText(this, "data inserted", Toast.LENGTH_SHORT).show();
        }
    }
}
