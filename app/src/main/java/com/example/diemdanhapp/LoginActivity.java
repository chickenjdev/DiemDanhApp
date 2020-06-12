package com.example.diemdanhapp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.UpdateLayout;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity  {
    String username = "";
    String pass = "";
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        final TextView inputUser = (TextView) findViewById(R.id.inputUser) ;
        final TextView inputPass = (TextView) findViewById(R.id.inputPassword) ;
        Button launchActivityTwoButton = (Button) findViewById(R.id.btnLogin);
        launchActivityTwoButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


               Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
               startActivity(intent);

                /*String txtUser = inputUser.getText().toString();
                String txtPass = inputPass.getText().toString();
                Toast.makeText(LoginActivity.this,""+txtUser+"-"+txtPass,Toast.LENGTH_SHORT).show();
                Log.i("LoginActivity","hello "+txtUser + ""+ txtPass);*/
            }
        });


    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);



    }
}

