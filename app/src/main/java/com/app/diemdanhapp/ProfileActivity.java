package com.app.diemdanhapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.model.loginModel;
import com.app.model.userInfo;


public class ProfileActivity  extends Activity{
    TextView txtFullname;
    EditText etxtPhone;
    EditText etxtAccommodation;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        txtFullname = (TextView)findViewById(R.id.txtFullname);

        txtFullname.setText(userInfo.getFull_name());
        btnUpdate.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
                etxtPhone = (EditText) findViewById(R.id.txtPhone);
                etxtPhone.setEnabled(true);
                etxtAccommodation= (EditText) findViewById(R.id.txtAccommodation);
                etxtAccommodation.setEnabled(true);

            }
        });

    }   @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

}


