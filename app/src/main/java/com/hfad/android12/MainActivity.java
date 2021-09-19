package com.hfad.android12;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText gmail_et,theme_et,text_et;
    private Button sendButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);



    }

    private void initViews() {    //метод для иницилизации

        gmail_et = findViewById(R.id.gmail_et);
        theme_et = findViewById(R.id.theme_et);
        text_et = findViewById(R.id.text_et);
       sendButton = findViewById(R.id.sendButton);
    }


    @SuppressLint("IntentReset")
    private  void  initListeners(){       //обработка клика


        sendButton.setOnClickListener(v -> {
            if(gmail_et.getText().toString().length()>0      //проверка на пустоту
                    &&text_et.getText().toString().length()>0
                    &&theme_et.getText().toString().length()>0)
            {


                String gmailData = gmail_et.getText().toString();      //переменные , где хранятся значения Edittextов
                String textData = text_et.getText().toString();
                String themeData = theme_et.getText().toString();


                Intent Email = new Intent(Intent.ACTION_SEND);//интент
                Email.setPackage("com.google.android.gm");
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL,new String[]{gmailData});
                Email.putExtra(Intent.EXTRA_SUBJECT, themeData);
                Email.putExtra(Intent.EXTRA_TEXT, textData);
                startActivity(Intent.createChooser(Email, "Send mail :"));


            }else{
                Toast.makeText(MainActivity.this,"fill in the data",Toast.LENGTH_LONG).show();  //Toast
            }
        });



    }

}