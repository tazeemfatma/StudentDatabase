package com.example.user.databasestud;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.databasestud.dbutil.StudentConstant;
import com.example.user.databasestud.dbutil.StudentManager;

public class SDelete extends AppCompatActivity implements DialogInterface.OnClickListener{
    EditText idroll;
    StudentManager studentManager;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdelete);
        idroll=findViewById(R.id.idroll);
        studentManager=new StudentManager(this);
        sqLiteDatabase=studentManager.openDB();
    }

    public void Delete(View view) {
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Record Deletion");
        ad.setMessage("are u sure u want to delete this record");
        ad.setPositiveButton("yes",this);
        ad.setNegativeButton("No",this);
        AlertDialog adg=ad.create();
        adg.show();

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch(i)
        {
            case DialogInterface.BUTTON_POSITIVE:
                {
                    deleteRecord();
                    break;
                }
                case DialogInterface.BUTTON_NEGATIVE:
                {

                }
        }

    }

    private void deleteRecord() {
        String id=idroll.getText().toString();
        if(TextUtils.isEmpty(id))
        {
            Toast.makeText(this, "enter roll", Toast.LENGTH_SHORT).show();
            return;
        }
        String[] args={id};
        int rw=sqLiteDatabase.delete(StudentConstant.TABLE_NAME,StudentConstant.COL_ID+"=?",args);
        if(rw>0)
        {
            Toast.makeText(this, "deleted successfully", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "no record exist", Toast.LENGTH_SHORT).show();
        }
    }

}
