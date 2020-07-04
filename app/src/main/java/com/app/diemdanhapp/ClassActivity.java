package com.app.diemdanhapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.service.gpsService;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class ClassActivity extends Activity {

    TextView txtSubCode,txtTittle;
    Button btnDiemdanh;
    TabLayout tablayoutDashBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtinmonhoc);

        txtSubCode = (TextView) findViewById(R.id.txtSubCode) ;
        txtTittle = (TextView) findViewById(R.id.txtTittle);
        btnDiemdanh =(Button) findViewById(R.id.btnDiemdanh);
        tablayoutDashBoard = (TabLayout) findViewById(R.id.tablayoutDashBoard);

        String classCode = getIntent().getStringExtra("CLASS_CODE");

        txtSubCode.setText(classCode);
        tablayoutDashBoard.getTabAt(0).setText(classCode);

        btnDiemdanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent attent = new Intent(ClassActivity.this,AttendActivity.class);
                startActivity(attent);
            }
        });

    }
}
