package com.app.diemdanhapp;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.app.model.loginModel;

public class LoginActivity extends Activity  {
    private String username = "";
    private String pass = "";

    Button btnLogin ;
    TextView inputUser ;
    TextView inputPass ;

    loginModel loginmodel;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        inputUser = (TextView) findViewById(R.id.inputUser) ;
        inputPass = (TextView) findViewById(R.id.inputPassword) ;

        btnLogin.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
                username = inputUser.getText().toString()+"@uit.edu.vn";
                pass = inputPass.getText().toString();
                loginmodel = new loginModel(LoginActivity.this,username,pass);
                loginmodel.login();
            }
        });

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);


    }


}

