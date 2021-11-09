package com.example.homegym_remake;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.*;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    DatabaseHelper helper; //DatabaseHelper class

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        helper = new DatabaseHelper(this);

        EditText join_nickname = (EditText) findViewById(R.id.join_nickname);
        EditText join_id = (EditText) findViewById(R.id.join_id);
        EditText join_password = (EditText) findViewById(R.id.join_password);
        EditText join_pwck = (EditText) findViewById(R.id.join_pwck);

        Button joinbtn = (Button)findViewById(R.id.joinbtn);
        joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = helper.insert_loginData(join_nickname.getText().toString(), join_id.getText().toString(), join_password.getText().toString());
                if(isInserted == true) {
                    Toast.makeText(SignUpActivity.this, "회원 가입에 성공 하셨습니다.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
                    else {
                    Toast.makeText(SignUpActivity.this, "회원 가입에 실패 하셨습니다. \t 빈 칸이 있습니다. ", Toast.LENGTH_LONG).show();
                }
            }
        });
        Button cancelbtn = (Button)findViewById(R.id.cancelbtn);
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
