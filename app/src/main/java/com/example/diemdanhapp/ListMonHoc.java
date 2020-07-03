package com.example.diemdanhapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListMonHoc extends AppCompatActivity {
    ArrayList<MonHoc> listMonHoc;
    MonHocAdapter MonHocViewAdapter;
    ListView listViewMonHoc;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        listMonHoc= new ArrayList<>();
        listMonHoc.add(new MonHoc("Web", "A", 100));
        listMonHoc.add(new MonHoc("App", "A", 1));
        listMonHoc.add(new MonHoc("CSDL", "A", 12));
        MonHocViewAdapter = new MonHocAdapter(listMonHoc);
        listViewMonHoc = findViewById(R.id.listviewdiemdanh);
        listViewMonHoc.setAdapter(MonHocViewAdapter);
        Button button = (Button) findViewById(R.id.xem);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ListMonHoc.this, ListSinhVien.class);
                startActivity(intent);

            }
        });

}}
