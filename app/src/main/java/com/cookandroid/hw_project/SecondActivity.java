package com.cookandroid.hw_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.lang.String;

public class SecondActivity extends Activity {

    ArrayList<String> idlist = new ArrayList<String>();
    ArrayList<String> passwordlist = new ArrayList<String>();
    ArrayList<String> namelist = new ArrayList<String>();
    ArrayList<String> phonelist = new ArrayList<String>();
    ArrayList<String> addlist = new ArrayList<String>();

    public void setIdlist(ArrayList<String> idlist, String s) {
        this.idlist.add(s);
    }

    public void setPasswordlist(ArrayList<String> passwordlist, String s) {
        this.passwordlist.add(s);
    }

    public void setNamelist(ArrayList<String> namelist, String s){
        this.namelist.add(s);
    }

    public void setPhonelist(ArrayList<String> phonelist, String s) {
        this.phonelist.add(s);
    }

    public void setAddlist(ArrayList<String> addlist, String s) {
        this.addlist.add(s);
    }

    Button btncheckid, btncheckpw, btnJoin, btnreturn;
    EditText id, password, name, phonenum, address;

    String text, ID, PASSWORD, NAME, PH, ADDR;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        setIdlist(idlist, "abc");
        setPasswordlist(passwordlist, "0000");
        setNamelist(namelist, "이인규");
        setPhonelist(phonelist, "010112345678");
        setAddlist(addlist, "대한민국");

        btncheckid = (Button) findViewById(R.id.checkduplicate);
        btncheckpw = (Button) findViewById(R.id.checkpassword);
        btnJoin = (Button) findViewById(R.id.btnJoin);
        btnreturn = (Button) findViewById(R.id.btnReturn);
        id = (EditText) findViewById(R.id.editnewid);
        password = (EditText) findViewById(R.id.editnewpassword);
        name = (EditText) findViewById(R.id.editname);
        phonenum = (EditText) findViewById(R.id.editphone);
        address = (EditText) findViewById(R.id.editaddress);

        btncheckid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                for(int i=0; i<idlist.size(); i++){
                    int index = i;

                    text = id.getText().toString();
                    if(text.equals(idlist.get(index))){
                        count++;
                    }

                }
                if(count == 0){
                    Toast.makeText(SecondActivity.this, "사용가능한 아이디입니다. ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SecondActivity.this, "이미 존재하는 아이디입니다. ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btncheckpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = password.getText().toString();
                if(isStringDouble(text)){
                    Toast.makeText(SecondActivity.this, "사용가능한 비밀번호입니다." ,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SecondActivity.this, "숫자만 입력하세요." , Toast.LENGTH_SHORT).show();
                }
            }
            public boolean isStringDouble(String s){
                try {
                    Double.parseDouble(s);
                    return true;
                }catch (NumberFormatException e){
                    return false;
                }
            }
        });


        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID = id.getText().toString();
                setIdlist(idlist, ID);
                PASSWORD = password.getText().toString();
                setPasswordlist(passwordlist, PASSWORD);
                NAME = name.getText().toString();
                setNamelist(namelist, NAME);
                PH = phonenum.getText().toString();
                setPhonelist(phonelist, PH);
                ADDR = address.getText().toString();
                setAddlist(addlist, ADDR);
                Toast.makeText(SecondActivity.this, "회원가입 완료", Toast.LENGTH_SHORT).show();
                Intent inintent = new Intent(getApplicationContext(), MainActivity.class);
                inintent.putExtra("Idlist", idlist);
                inintent.putExtra("Passwordlist", passwordlist);
                startActivity(inintent);
            }
        });

        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
