package com.example.user.databasestud;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.user.databasestud.dbutil.StudentConstant;
import com.example.user.databasestud.dbutil.StudentManager;

public class Update extends AppCompatActivity {
EditText uroll,uname,uemail,uphone;
Spinner ucourse;
StudentManager studentManager;
SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        uroll=findViewById(R.id.uroll);
        uname=findViewById(R.id.uname);
        ucourse=findViewById(R.id.ucourse);
        uemail=findViewById(R.id.uemail);
        uphone=findViewById(R.id.uphone);
        studentManager=new StudentManager(this);
        sqLiteDatabase=studentManager.openDB();
        Intent i=getIntent();
        String h=i.getStringExtra("rollno");

        populatedata(h);
    }

    private void populatedata(String h) {
        //String id=roll.getText().toString();


        String[] args={h};
        String[] colnames={StudentConstant.COL_NAME,StudentConstant.COL_COURSE,StudentConstant.COL_PHONE,StudentConstant.COL_EMAIL};
        Cursor c=sqLiteDatabase.query(StudentConstant.TABLE_NAME,colnames,StudentConstant.COL_ID+" =?",args,null,null,null);
    if(c!=null && c.moveToFirst())
    {
        String n=c.getString(c.getColumnIndex(StudentConstant.COL_NAME));
        String cr=c.getString(c.getColumnIndex(StudentConstant.COL_COURSE));


        String p=c.getString(c.getColumnIndex(StudentConstant.COL_PHONE));
        String e=c.getString(c.getColumnIndex(StudentConstant.COL_EMAIL));
        uroll.setText(h);
        uname.setText(n);
        uphone.setText(p);
        uemail.setText(e);

    }
    }

    public void Update(View view) {
        String n=uname.getText().toString();
        String c=(String)ucourse.getSelectedItem();
        String p=uphone.getText().toString();
        String e=uemail.getText().toString();
        String id=uroll.getText().toString();
        String[] args={id};
        ContentValues cv=new ContentValues();

        cv.put(StudentConstant.COL_NAME,n);
        cv.put(StudentConstant.COL_COURSE,c);
        cv.put(StudentConstant.COL_PHONE,p);
        cv.put(StudentConstant.COL_EMAIL,e);
        int rw=sqLiteDatabase.update(StudentConstant.TABLE_NAME,cv,StudentConstant.COL_ID+" =?",args);
        if(rw>0)
        {
            Toast.makeText(this, "updated successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
