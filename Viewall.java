package com.example.user.databasestud;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.databasestud.dbutil.StudentConstant;
import com.example.user.databasestud.dbutil.StudentManager;

import java.util.ArrayList;

public class Viewall extends AppCompatActivity implements AdapterView.OnItemClickListener {
    StudentManager studentManager;
    SQLiteDatabase sqLiteDatabase;
    Studentbean st;
    ArrayList<Studentbean> studentlist;
    ListView studdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall);
        studdata=findViewById(R.id.studdata);
        studentlist=new ArrayList<>();
        studentManager=new StudentManager(this);
        sqLiteDatabase=studentManager.openDB();
        populateList();
    }

    private void populateList() {
       // String[] colname = {StudentConstant.COL_NAME,StudentConstant.COL_PHONE};

      //  Cursor cursor = sqLiteDatabase.query(StudentConstant.TABLE_NAME,colname, null, null, null, null, null);
        Cursor cursor = sqLiteDatabase.query(StudentConstant.TABLE_NAME,null, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String r=cursor.getString(cursor.getColumnIndex(StudentConstant.COL_ID));
                String n=cursor.getString(cursor.getColumnIndex(StudentConstant.COL_NAME));
                String c=cursor.getString(cursor.getColumnIndex(StudentConstant.COL_COURSE));
                String p=cursor.getString(cursor.getColumnIndex(StudentConstant.COL_PHONE));
                String e=cursor.getString(cursor.getColumnIndex(StudentConstant.COL_EMAIL));
                st=new Studentbean(r,n,c,p,e);
                studentlist.add(st);


            } while (cursor.moveToNext());
            ArrayAdapter<Studentbean> ad = new ArrayAdapter<Studentbean>(this, android.R.layout.simple_list_item_1, studentlist);
            studdata.setAdapter(ad);
            studdata.setOnItemClickListener(this);

        }


    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Studentbean st=studentlist.get(i);
        String num=st.getEmail();
        //String id=st.getRoll();
       Toast.makeText(this, " "+num, Toast.LENGTH_SHORT).show();
       Intent intent=new Intent(Intent.ACTION_CALL);
        Uri u =Uri.parse("tel:"+num);
        intent.setData(u);
       if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

           return;
       }
        startActivity(intent);
    }
}
