package com.example.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         Intent intent = getIntent();
        String accountType = intent.getStringExtra("user");
        String account = intent.getStringExtra("account");
        String password = intent.getStringExtra("password");
        TextView textView = findViewById(R.id.textView2);
        textView.setText(accountType+"用户欢迎您"+"\n"+"您的账号为:"+account+"\n"+"密码为:"+password);
        ImageView close = findViewById(R.id.imageView2);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
