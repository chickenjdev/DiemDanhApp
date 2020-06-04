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
public class LoginActivity extends Activity  {
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        Button launchActivityTwoButton = (Button) findViewById(R.id.btnLogin);

        launchActivityTwoButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);



            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);



    }
}

