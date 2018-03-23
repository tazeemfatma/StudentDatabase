package com.example.user.databasestud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SUpdate extends AppCompatActivity {
    EditText rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supdate);
        rl=findViewById(R.id.rl);
    }

    public void UpdateData(View view) {
        String n=rl.getText().toString();
        Intent intent=new Intent(this,Update.class);
        intent.putExtra("rollno",n);
        startActivity(intent);
    }
}
