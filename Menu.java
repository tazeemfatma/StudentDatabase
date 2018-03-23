package com.example.user.databasestud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void add(View view) {
        Intent intent=new Intent(this,Student.class);
        startActivity(intent);
    }

    public void update(View view) {
        Intent intent=new Intent(this,SUpdate.class);
        startActivity(intent);
    }

    public void delete(View view) {
        Intent intent=new Intent(this,SDelete.class);
        startActivity(intent);
    }

    public void viewall(View view) {
        Intent intent=new Intent(this,Viewall.class);
        startActivity(intent);
    }

    public void search(View view) {
        Intent intent=new Intent(this,Search.class);
        startActivity(intent);
    }
}
