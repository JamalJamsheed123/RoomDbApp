package com.example.roomdbapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateData extends AppCompatActivity
{
    int uid;
    EditText fname, lname;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        fname=findViewById(R.id.editname);
        lname=findViewById(R.id.editemail);
        btn=findViewById(R.id.btn);

        uid=Integer.parseInt(getIntent().getStringExtra("uid"));
        fname.setText(getIntent().getStringExtra("ufname"));
        lname.setText(getIntent().getStringExtra("ulname"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "room_db").allowMainThreadQueries().build();
                UserDao userDao = db.userDao();
                userDao.updateById(uid,fname.getText().toString(),lname.getText().toString());
                startActivity(new Intent(getApplicationContext(),FetchData.class));
                finish();
            }
        });
    }




}