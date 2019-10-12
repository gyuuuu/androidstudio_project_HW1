package com.cookandroid.hw_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> idlist = new ArrayList<String>();
    ArrayList<String> passwordlist = new ArrayList<String>();
    ArrayList<String> namelist = new ArrayList<String>();
    ArrayList<String> phonelist = new ArrayList<String>();
    ArrayList<String> addlist = new ArrayList<String>();

    EditText ID, PASSWORD;
    String id, password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");


        ID = (EditText) findViewById(R.id.edittextid);
        PASSWORD = (EditText) findViewById(R.id.edittextpassword);


        Button btnNewActivity1 = (Button) findViewById(R.id.btnNewActivity1);
        btnNewActivity1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Idlist", idlist);
                intent.putExtra("Passwordlist", passwordlist);
                intent.putExtra("Namelist", namelist);
                intent.putExtra("Phonelist", phonelist);
                intent.putExtra("Addlist", addlist);
                startActivityForResult(intent, 0);
            }
        });


        Button btnNewActivity2 = (Button) findViewById(R.id.btnNewActivity2);
        btnNewActivity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int count = 0;
                id = ID.getText().toString();
                password = PASSWORD.getText().toString();
                //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                for(int i=0; i<idlist.size(); i++){
                    if(id.equals(idlist.get(i))){
                        int index = i;
                        if(password.equals(passwordlist.get(index))){
                            Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                            startActivity(intent);
                            break;
                        }
                        else{
                            Toast.makeText(MainActivity.this, "비밀번호 오류", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        count++;
                    }

                }

                if(count == idlist.size()){
                    Toast.makeText(MainActivity.this, "회원정보 없음", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode){
                case 0:
                    ArrayList<String> lista = data.getStringArrayListExtra("IDlist");
                    ArrayList<String> listb = data.getStringArrayListExtra("PassWordlist");
                    idlist = lista;
                    passwordlist = listb;
                    break;
            }
        }
    }
}
