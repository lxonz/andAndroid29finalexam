package com.example.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private EditText account;
    private TextView login;
    private EditText password;
    private RadioButton accountlogin;
    private RadioButton accountshouji;
    private RadioButton accountemail;
    private Button loginclick;
    private RadioGroup radioGroup;
    private int cont;
    private String user;
    private String accounttiao;
    private String passwordtiao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.textView);
        account=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        accountlogin=findViewById(R.id.zhanghao);
        accountshouji=findViewById(R.id.shouji);
        accountemail=findViewById(R.id.email);
        loginclick=findViewById(R.id.button);
        radioGroup=findViewById(R.id.group);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"ttf/SIMLI.TTF");
        login.setTypeface(typeface);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                      {
                                                          cont=checkedId;
                                                          if(cont==R.id.zhanghao){
                                                              account.setHint(R.string.hint_l1);
                                                              account.setInputType(InputType.TYPE_CLASS_TEXT);
                                                              user=accountlogin.getText().toString();
                                                          }
                                                          else if(cont==R.id.shouji){
                                                              account.setHint(R.string.hint_l2);
                                                              account.setInputType(InputType.TYPE_CLASS_PHONE);
                                                              user=accountshouji.getText().toString();
                                                          }
                                                          else if (cont==R.id.email){
                                                              account.setHint(R.string.email);
                                                              account.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                                                              user=accountemail.getText().toString();
                                                          }
                                                      }
                                                  }
                                              });
                loginclick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String accounttiao = account.getText().toString();
                        String passwordtiao= password.getText().toString();
                        user=accountlogin.getText().toString();
                        if (accounttiao.equals("") || passwordtiao.equals("")) {
                            Toast.makeText(MainActivity.this, "请输入账户信息", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                            intent.putExtra("user",user);
                            intent.putExtra("account", accounttiao);
                            intent.putExtra("password", passwordtiao);
                            startActivity(intent);
                        }
                    }
                });
    }
}
