package com.example.diemdanhapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class UIDiemDanh extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        ArrayList list = new ArrayList();
        TextView txtTenMon;
        TextView txtMaMon;
        TextView txtGiangVien;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtinmonhoc);
        txtTenMon = (TextView) findViewById(R.id.tenmon);
        txtMaMon = (TextView) findViewById(R.id.IDmon);
        txtGiangVien = (TextView) findViewById(R.id.giangvien);
        txtTenMon.setText("");
        txtMaMon.setText("");
        txtGiangVien.setText("");





    }

}
